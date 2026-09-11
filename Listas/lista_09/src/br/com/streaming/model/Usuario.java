package br.com.streaming.model;

public class Usuario {
    public static final String PLATAFORMA = "JavaFlix";
    private static int totalUsuarios = 0;

    private String nome;
    private String email;
    private boolean ativo;

    public Usuario(String nome, String email, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        totalUsuarios++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    @Override
    public String toString() {
        return "Usuario: " + nome + " | Contato: " + email + " | Ativo: " + ativo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario outro = (Usuario) obj;
        return email.equals(outro.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
