package br.com.autotech.main;

import br.com.autotech.dao.PecaDao;
import br.com.autotech.model.Peca;
import java.util.List;
import java.util.Scanner;

/**
 * ============================================================================
 * SISTEMA OFICINA AUTOTECH • BANCADA DE LABORATÓRIO (AULA 26)
 * ============================================================================
 * Aplicação interativa de bancada para testar o CRUD em SQLite (autotech.db).
 * ============================================================================
 */
public class MainApp {

    public static void main(String[] args) {
        System.out.println("====================================================================");
        System.out.println("🔧 AutoTech Parts • Sistema de Gestão de Estoque Local (Aula 26)");
        System.out.println("   Disciplina: Programação Orientada a Objetos • UniCesumar");
        System.out.println("   Prof. Mestre Júlio B. Herculani");
        System.out.println("====================================================================");

        PecaDao dao = new PecaDao();

        // 1. Executa a Missão 1 (Criação da tabela)
        dao.criarTabelaSeNaoExistir();

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n--------------------------------------------------------------------");
            System.out.println("PAINEL DO MECÂNICO (autotech.db):");
            System.out.println(" [1] Listar todas as peças em estoque (Missão 3)");
            System.out.println(" [2] Cadastrar nova peça avulsa (Missão 2)");
            System.out.println(" [3] Buscar peça por código (Missão 4)");
            System.out.println(" [4] Dar baixa em estoque / Saída de balcão (Missão 5)");
            System.out.println(" [5] Semear 3 peças padrão da oficina (Carga Rápida)");
            System.out.println(" [0] Sair e salvar no disco rígido");
            System.out.print("👉 Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1" -> listar(dao);
                case "2" -> cadastrar(dao, scanner);
                case "3" -> buscar(dao, scanner);
                case "4" -> darBaixa(dao, scanner);
                case "5" -> semear(dao);
                case "0" -> {
                    System.out.println("\n👋 Encerrando o sistema AutoTech. Arquivo 'autotech.db' salvo no disco!");
                    executando = false;
                }
                default -> System.out.println("⚠️ Opção inválida!");
            }
        }

        scanner.close();
    }

    private static void listar(PecaDao dao) {
        System.out.println("\n--- ESTOQUE FÍSICO DA OFICINA AUTOTECH ---");
        List<Peca> pecas = dao.listarTodas();

        if (pecas.isEmpty()) {
            System.out.println("⚠️ Nenhuma peça encontrada no banco (ou Missão 3 ainda não implementada).");
        } else {
            System.out.println("-------------------------------------------------------------------------------");
            for (Peca p : pecas) {
                System.out.println(p);
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Total de itens distintos: " + pecas.size());
        }
    }

    private static void cadastrar(PecaDao dao, Scanner scanner) {
        System.out.println("\n--- CADASTRO DE PEÇA ---");
        try {
            System.out.print("Código da peça (ex: PAS-101): ");
            String codigo = scanner.nextLine().trim().toUpperCase();

            System.out.print("Nome descritivo: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Preço unitário (R$): ");
            double preco = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));

            System.out.print("Quantidade em estoque: ");
            int estoque = Integer.parseInt(scanner.nextLine().trim());

            Peca nova = new Peca(codigo, nome, preco, estoque);
            dao.salvar(nova);

        } catch (NumberFormatException e) {
            System.err.println("❌ Erro: Formato numérico inválido para preço ou quantidade.");
        }
    }

    private static void buscar(PecaDao dao, Scanner scanner) {
        System.out.println("\n--- CONSULTA POR CÓDIGO ---");
        System.out.print("Digite o código da peça (ex: PAS-101): ");
        String codigo = scanner.nextLine().trim().toUpperCase();

        Peca peca = dao.buscarPorCodigo(codigo);
        if (peca != null) {
            System.out.println("✅ Peça localizada:");
            System.out.println("   -> " + peca);
        } else {
            System.out.println("❌ Peça com código '" + codigo + "' não foi encontrada no banco.");
        }
    }

    private static void darBaixa(PecaDao dao, Scanner scanner) {
        System.out.println("\n--- BAIXA DE ESTOQUE (SAÍDA DE OFICINA) ---");
        try {
            System.out.print("Digite o ID da peça: ");
            Long id = Long.parseLong(scanner.nextLine().trim());

            System.out.print("Quantidade retirada: ");
            int qtd = Integer.parseInt(scanner.nextLine().trim());

            boolean sucesso = dao.darBaixaEstoque(id, qtd);
            if (sucesso) {
                System.out.println("✅ Baixa de " + qtd + " unidade(s) confirmada com sucesso!");
            } else {
                System.out.println("❌ Falha na baixa: ID inexistente ou estoque insuficiente!");
            }

        } catch (NumberFormatException e) {
            System.err.println("❌ Erro: Entrada numérica inválida.");
        }
    }

    private static void semear(PecaDao dao) {
        System.out.println("\n--- INSERINDO 3 PEÇAS PADRÃO DA OFICINA ---");
        dao.salvar(new Peca("PAS-101", "Pastilha de Freio Dianteira Bosch", 145.50, 12));
        dao.salvar(new Peca("FIL-202", "Filtro de Óleo Motor TecFil", 38.90, 30));
        dao.salvar(new Peca("VEL-303", "Jogo 4 Velas de Ignição NGK", 112.00, 15));
        System.out.println("✅ Peças semeadas com sucesso no SQLite!");
    }
}
