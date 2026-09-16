package br.com.techinvoice.main;

import br.com.techinvoice.model.DocumentoFactory;
import br.com.techinvoice.model.GerenciadorConfiguracao;
import br.com.techinvoice.model.IDocumento;

public class Main {
    public static void main(String[] args) {
        GerenciadorConfiguracao gen1 = GerenciadorConfiguracao.getInstance();
        System.out.println("Api Key: " + gen1.getApiKey());

        GerenciadorConfiguracao gen2 = GerenciadorConfiguracao.getInstance();
        if (gen1 == gen2) {
            System.out.println("As duas variaveis apontam para a mesma instancia!");
        }

        IDocumento nf = DocumentoFactory.criarDocumento("NF");
        nf.gerarPDF();

        try {
            IDocumento boleto = DocumentoFactory.criarDocumento("BOLETO");
            boleto.gerarPDF();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro amigavel: " + e.getMessage());
        }
    }
}
