package br.com.streaming.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sede {
    private String[] vagasGaragem = new String[3];
    private List<Credencial> historicoCatraca = new ArrayList<>();
    private Set<Credencial> acessoCofre = new HashSet<>();

    public void estacionarVeiculo(String placa, int vaga) {
        vagasGaragem[vaga] = placa;
        System.out.println("Veiculo " + placa + " estacionado na vaga " + vaga);
    }

    public void registrarPassagemCatraca(Credencial c) {
        historicoCatraca.add(c);
        System.out.println("Passagem registrada: " + c.getCodigoHex());
    }

    public void autorizarEntradaCofre(Credencial c) {
        if (acessoCofre.add(c)) {
            System.out.println("Entrada autorizada no cofre: " + c.getCodigoHex());
        } else {
            System.out.println("Alerta de Seguranca: Tentativa de acesso duplicado com credencial ja ativa no cofre");
        }
    }
}
