package br.com.bookstore.main;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAOSqlite();

        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 89.90);
        Livro l2 = new Livro("Design Patterns", "Gang of Four", 150.00);
        Livro l3 = new Livro("Refactoring", "Martin Fowler", 120.50);
        dao.salvar(l1);
        dao.salvar(l2);
        dao.salvar(l3);
        System.out.println("Livro salvo com ID " + l1.getId() + ": " + l1.getTitulo());
        System.out.println("Livro salvo com ID " + l2.getId() + ": " + l2.getTitulo());
        System.out.println("Livro salvo com ID " + l3.getId() + ": " + l3.getTitulo());

        System.out.println();
        System.out.println("Buscando livro de ID 2...");
        dao.buscarPorId(2L).ifPresentOrElse(
                livro -> System.out.println("Encontrado: " + livro),
                () -> System.out.println("Nenhum livro com ID 2 foi encontrado."));

        System.out.println();
        System.out.println("Buscando livro de ID 999...");
        dao.buscarPorId(999L).ifPresentOrElse(
                livro -> System.out.println("Encontrado: " + livro),
                () -> System.out.println("Nenhum livro com ID 999 foi encontrado."));

        System.out.println();
        List<Livro> livros = dao.listarTodos();
        System.out.println("================== CATALOGO BOOKSTORE ==================");
        System.out.println("ID      | TITULO               | AUTOR                | PRECO");
        System.out.println("--------------------------------------------------------");
        for (Livro l : livros) {
            System.out.println(l);
        }
        System.out.println("Total de livros: " + livros.size());
    }
}
