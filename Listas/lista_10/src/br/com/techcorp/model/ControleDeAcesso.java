package br.com.techcorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControleDeAcesso {
    private List<Funcionario> historicoCatraca = new ArrayList<>();
    private Set<Funcionario> autorizadosSalaSegura = new HashSet<>();

    public void registrarPassagem(Funcionario f) {
        historicoCatraca.add(f);
        System.out.println("Passagem registrada na catraca: " + f.getNome());
    }

    public void concederAcessoSala(Funcionario f) {
        if (autorizadosSalaSegura.add(f)) {
            System.out.println("Acesso liberado para a Sala Segura");
        } else {
            System.out.println("Aviso: Matricula ja registrada na sala. Acesso nao permitido.");
        }
    }
}
