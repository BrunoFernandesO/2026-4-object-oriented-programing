package br.com.technexus.main;

import br.com.technexus.model.Loja;
import br.com.technexus.model.Produto;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        loja.cadastrar(new Produto("The Witcher", "GAMES", 150.0));
        loja.cadastrar(new Produto("FIFA", "GAMES", 200.0));
        loja.cadastrar(new Produto("Java for Dummies", "LIVROS", 100.0));
        loja.cadastrar(new Produto("Clean Code", "LIVROS", 80.0));
        loja.cadastrar(new Produto("Mouse", "HARDWARE", 50.0));

        System.out.println("Categoria GAMES:");
        for (Produto p : loja.buscarPorCategoria("GAMES")) {
            System.out.println(p);
        }

        System.out.println("Patrimonio total: " + loja.calcularPatrimonioTotal());
        System.out.println("Total em LIVROS: " + loja.calcularTotalPorCategoria("LIVROS"));
    }
}
