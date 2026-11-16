package br.com.bookstore.model;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private double preco;

    public Livro(Long id, String titulo, String autor, double preco) {
        if (titulo == null || titulo.trim().length() < 2) {
            throw new IllegalArgumentException("O titulo do livro deve ter pelo menos 2 caracteres");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor do livro nao pode ser vazio");
        }
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço de venda deve ser estritamente positivo");
        }
        this.id = id;
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.preco = preco;
    }

    public Livro(String titulo, String autor, double preco) {
        this(null, titulo, autor, preco);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | %-20s | %-20s | R$ %8.2f", id, titulo, autor, preco);
    }
}
