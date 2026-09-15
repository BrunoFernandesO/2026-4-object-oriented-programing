package br.com.technexus.model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> catalogo = new ArrayList<>();

    public void cadastrar(Produto p) {
        this.catalogo.add(p);
    }

    public List<Produto> buscarPorCategoria(String catDesejada) {
        return this.catalogo.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(catDesejada))
                .toList();
    }

    public double calcularPatrimonioTotal() {
        return this.catalogo.stream()
                .mapToDouble(p -> p.getPreco())
                .sum();
    }

    public double calcularTotalPorCategoria(String catDesejada) {
        return this.catalogo.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(catDesejada))
                .mapToDouble(p -> p.getPreco())
                .sum();
    }
}
