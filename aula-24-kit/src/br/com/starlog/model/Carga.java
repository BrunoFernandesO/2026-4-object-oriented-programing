package br.com.starlog.model;

/**
 * CAMADA MODEL (Modelo de Domínio)
 * Representa uma carga a ser despachada pela estação StarLog.
 * 
 * ATENÇÃO: Esta classe NÃO deve importar nenhum componente visual do Swing!
 */
public class Carga {
    private final String codigoRastreio;
    private final String categoria;
    private final double peso;
    private final double valorDeclarado;

    public Carga(String codigoRastreio, String categoria, double peso, double valorDeclarado) {
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException("Código de rastreio não pode ser nulo ou vazio.");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria não pode ser nula ou vazia.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser estritamente positivo (maior que zero).");
        }
        if (valorDeclarado <= 0) {
            throw new IllegalArgumentException("Valor declarado deve ser maior que zero.");
        }
        this.codigoRastreio = codigoRastreio.trim().toUpperCase();
        this.categoria = categoria.trim().toUpperCase();
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPeso() {
        return peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    /**
     * Regra de Negócio: Cálculo do Seguro Espacial da Carga.
     * Cargas perigosas ou pesadas possuem taxa base diferenciada.
     */
    public double calcularSeguro() {
        double seguro = valorDeclarado * 0.02;
        if (categoria.equals("PERIGOSA") || peso > 100) {
            seguro += 150.0;
        }
        return seguro;
    }

    @Override
    public String toString() {
        return String.format("[%s] Categoria: %s | Peso: %.2f kg | Valor: R$ %.2f | Seguro: R$ %.2f",
                codigoRastreio, categoria, peso, valorDeclarado, calcularSeguro());
    }
}
