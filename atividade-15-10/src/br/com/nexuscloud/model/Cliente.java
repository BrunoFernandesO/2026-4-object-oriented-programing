package br.com.nexuscloud.model;

import java.util.Objects;

// classe POJO do cliente, atributos privados pra garantir o encapsulamento - RA: 25291321-2
public class Cliente {

    // cpf e o identificador do cliente, por isso e final (nao muda depois de criado) - RA: 25291321-2
    private final String cpf;
    private String nome;

    // construtor que recebe cpf e nome e guarda nos atributos - RA: 25291321-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // getters pra ler os dados de fora da classe - RA: 25291321-2
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    // dois clientes sao iguais se tiverem o mesmo cpf, nao importa o endereco de memoria - RA: 25291321-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente outro = (Cliente) obj;
        return cpf.equals(outro.cpf);
    }

    // hashCode usa so o cpf, assim o HashMap acha o cliente no mesmo "balde" - RA: 25291321-2
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
