package br.com.techinvoice.model;

public class Recibo implements IDocumento {
    public void gerarPDF() {
        System.out.println("Gerando Recibo simples de pagamento...");
    }
}
