package br.com.starlog.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(Long id, String nome, double preco, int estoque) {
        if (nome == null || nome.length() < 3) {
            throw new IllegalArgumentException("Nome precisa ter pelo menos 3 caracteres");
        }
        if (preco <= 0.0) {
            throw new IllegalArgumentException("Preco tem que ser maior que zero");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque nao pode ser negativo");
        }
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, double preco, int estoque) {
        this(null, nome, preco, estoque);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("Preco tem que ser maior que zero");
        }
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque nao pode ser negativo");
        }
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("%-4d | %-25s | R$ %8.2f | %5d un", id, nome, preco, estoque);
    }
}
