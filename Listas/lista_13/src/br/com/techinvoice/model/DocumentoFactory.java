package br.com.techinvoice.model;

public class DocumentoFactory {
    public static IDocumento criarDocumento(String tipo) {
        if (tipo.equals("NF")) {
            return new NotaFiscal();
        } else if (tipo.equals("RECIBO")) {
            return new Recibo();
        } else {
            throw new IllegalArgumentException("Documento invalido: " + tipo);
        }
    }
}
