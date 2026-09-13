package br.com.nexustech.model;

import br.com.nexustech.exception.BanidoException;

public class Matchmaker {
    public void encontrarSala(ModoJogo modo, boolean jogadorBanido) throws BanidoException {
        if (jogadorBanido) {
            throw new BanidoException();
        }
        modo.buscarPartida();
    }
}
