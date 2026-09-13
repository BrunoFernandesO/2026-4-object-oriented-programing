package br.com.nexustech.model;

import br.com.nexustech.exception.NivelInsuficienteException;

public class Masmorra {
    public void entrar(int nivelJogador) {
        if (nivelJogador < 50) {
            throw new NivelInsuficienteException();
        }
        System.out.println("Bem-vindo a masmorra!");
    }
}
