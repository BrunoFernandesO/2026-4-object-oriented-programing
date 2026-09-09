package br.com.banco.main;

import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Joao", "joao@email.com", "111.222.333-44");
        Cliente c2 = new Cliente("Joao da Silva", "outro@email.com", "111.222.333-44");

        if (c1.equals(c2)) {
            System.out.println("Os clientes sao iguais (mesmo CPF).");
        } else {
            System.out.println("Os clientes sao diferentes.");
        }

        ContaBancaria conta = new ContaBancaria("0001", c1, 50.0);
        boolean resultado = conta.sacar(50.0);
        System.out.println("Resultado do saque de 50.0: " + resultado);

        System.out.println("Total de contas abertas: " + Agencia.totalContasAbertas);
    }
}
