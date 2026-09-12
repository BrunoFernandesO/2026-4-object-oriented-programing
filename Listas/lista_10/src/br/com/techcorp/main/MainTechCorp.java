package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

public class MainTechCorp {
    public static void main(String[] args) {
        ControleDeAcesso controle = new ControleDeAcesso();

        Funcionario f1 = new Funcionario("T-001", "Alice", "Analista");
        Funcionario f2 = new Funcionario("T-001", "Alice Duplicada", "Analista");

        controle.registrarPassagem(f1);
        controle.registrarPassagem(f2);

        controle.concederAcessoSala(f1);
        controle.concederAcessoSala(f2);
    }
}
