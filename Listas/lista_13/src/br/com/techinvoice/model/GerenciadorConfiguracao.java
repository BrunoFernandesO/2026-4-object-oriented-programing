package br.com.techinvoice.model;

public class GerenciadorConfiguracao {
    private static GerenciadorConfiguracao instancia;
    private String apiKey = "AWS-12345-KEY";

    private GerenciadorConfiguracao() {
    }

    public static GerenciadorConfiguracao getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorConfiguracao();
        }
        return instancia;
    }

    public String getApiKey() {
        return apiKey;
    }
}
