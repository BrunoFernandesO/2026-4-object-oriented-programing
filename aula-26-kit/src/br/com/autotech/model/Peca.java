package br.com.autotech.model;

/**
 * ============================================================================
 * CLASSE DE MODELO (MODEL / POJO) • PEÇA DE REPOSIÇÃO (AUTOTECH)
 * ============================================================================
 * Mapeia a tabela "pecas" no banco de dados local "autotech.db".
 * ============================================================================
 */
public class Peca {

    private Long id;
    private String codigo;   // Ex: "FIL-101", "PAS-202"
    private String nome;     // Ex: "Filtro de Óleo Lubrificante"
    private double preco;    // Ex: 45.90
    private int estoque;     // Ex: 18 unidades

    public Peca() {
    }

    public Peca(String codigo, String nome, double preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Peca(Long id, String codigo, String nome, double preco, int estoque) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Cód: %-8s | %-30s | R$ %7.2f | Estoque: %3d un",
                id != null ? id : 0, codigo, nome, preco, estoque);
    }
}
