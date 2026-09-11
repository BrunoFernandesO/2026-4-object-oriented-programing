package br.com.cybercorp.model;

public class Departamento {
    private String nome;
    private String andar;

    public Departamento(String nome, String andar) {
        this.nome = nome;
        this.andar = andar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "Departamento: " + nome + " (Andar " + andar + ")";
    }
}
