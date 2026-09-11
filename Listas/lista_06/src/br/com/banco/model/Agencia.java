package br.com.banco.model;

public class Agencia {
    public static final String NOME_BANCO = "JavaBank";
    public static final double TAXA_SAQUE = 5.0;
    public static int totalContasAbertas = 0;

    public static void registrarNovaConta() {
        totalContasAbertas++;
    }
}
