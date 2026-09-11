package br.com.streaming.main;

import br.com.streaming.model.Credencial;
import br.com.streaming.model.Sede;

public class MainSeguranca {
    public static void main(String[] args) {
        Sede sede = new Sede();
        Credencial cred = new Credencial("A1B2C3");

        sede.registrarPassagemCatraca(cred);
        sede.registrarPassagemCatraca(cred);

        sede.autorizarEntradaCofre(cred);
        sede.autorizarEntradaCofre(cred);

        sede.estacionarVeiculo("AAA-0001", 0);
        sede.estacionarVeiculo("BBB-0002", 1);
        sede.estacionarVeiculo("CCC-0003", 2);
        sede.estacionarVeiculo("DDD-0004", 3);
    }
}
