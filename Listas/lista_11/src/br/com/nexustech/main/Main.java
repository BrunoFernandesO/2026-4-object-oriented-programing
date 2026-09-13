package br.com.nexustech.main;

import br.com.nexustech.model.Masmorra;
import br.com.nexustech.model.Matchmaker;
import br.com.nexustech.model.ModoCasual;
import br.com.nexustech.model.ModoJogo;
import br.com.nexustech.model.ModoRanqueado;
import br.com.nexustech.exception.BanidoException;

public class Main {
    public static void main(String[] args) {
        int kills = 15;
        int deaths = 0;

        try {
            System.out.println(kills / deaths);
        } catch (ArithmeticException e) {
            System.out.println("Taxa K/D: Jogador Invicto!");
        }

        String[] inventario = new String[3];
        try {
            inventario[5] = "Espada";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inventario cheio!");
        }

        String jogador = null;
        if (jogador != null) {
            System.out.println(jogador);
        } else {
            System.out.println("Jogador desconectado");
        }

        try {
            conectarServidor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fechando portas de rede do jogo...");
        }

        Masmorra masmorra = new Masmorra();
        try {
            masmorra.entrar(20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Matchmaker matchmaker = new Matchmaker();
        ModoJogo casual = new ModoCasual();
        ModoJogo ranqueado = new ModoRanqueado();
        try {
            matchmaker.encontrarSala(casual, true);
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void conectarServidor() throws Exception {
        throw new Exception("Servidor caiu!");
    }
}
