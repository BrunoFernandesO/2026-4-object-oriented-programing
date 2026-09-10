package br.com.cybercorp.model;

public class Funcionario {
    private String nome;
    private String matricula;
    private Departamento departamento;

    public Funcionario(String nome, String matricula, Departamento departamento) {
        this.nome = nome;
        this.matricula = matricula;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + " | Matricula: " + matricula;
    }
}
