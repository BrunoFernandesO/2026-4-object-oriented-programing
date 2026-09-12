package br.com.techcorp.model;

public class Funcionario {
    private String matricula;
    private String nome;
    private String cargo;

    public Funcionario(String matricula, String nome, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Funcionario outro = (Funcionario) obj;
        return matricula.equals(outro.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + " | Matricula: " + matricula + " | Cargo: " + cargo;
    }
}
