package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOSqlite();

        System.out.println("=== [Create] ===");
        Produto teclado = new Produto("Teclado Mecânico RGB", 349.90, 20);
        Produto mousepad = new Produto("Mousepad Speed XL", 89.90, 40);
        dao.salvar(teclado);
        dao.salvar(mousepad);
        System.out.println("Teclado salvo com ID " + teclado.getId());
        System.out.println("Mousepad salvo com ID " + mousepad.getId());

        System.out.println();
        System.out.println("=== [Read] ===");
        mostrarLista(dao.listarTodos());

        System.out.println();
        System.out.println("=== [Update] ===");
        teclado.setPreco(289.90);
        teclado.setEstoque(15);
        boolean ok = dao.atualizar(teclado);
        System.out.println("Atualizou? " + ok);
        dao.buscarPorId(teclado.getId()).ifPresentOrElse(
                p -> System.out.println("Registro atualizado: " + p),
                () -> System.out.println("Produto nao encontrado"));

        System.out.println();
        System.out.println("=== [Delete] ===");
        if (dao.excluir(mousepad.getId())) {
            System.out.println("Mousepad (ID " + mousepad.getId() + ") removido");
        } else {
            System.out.println("Nao foi possivel remover o mousepad");
        }
        Long idFalso = 888L;
        if (dao.excluir(idFalso)) {
            System.out.println("Produto " + idFalso + " removido");
        } else {
            System.out.println("Nenhum produto com ID " + idFalso + " foi encontrado, nada foi excluido");
        }

        System.out.println();
        System.out.println("=== [Final State] ===");
        List<Produto> finais = dao.listarTodos();
        mostrarLista(finais);
        System.out.println("Total de produtos no banco: " + finais.size());
    }

    public static void mostrarLista(List<Produto> lista) {
        System.out.println(String.format("%-4s | %-25s | %11s | %8s", "ID", "Nome", "Preco", "Estoque"));
        System.out.println("-----------------------------------------------------------");
        for (Produto p : lista) {
            System.out.println(p);
        }
    }
}
