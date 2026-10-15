package br.com.nexuscloud.model;

import java.util.Objects;

// classe que representa uma aplicacao (container) que roda dentro de um servidor - RA: 25291321-2
public class Container {

    // id e o identificador unico do container, por isso final - RA: 25291321-2
    private final String id;
    private String nomeApp;
    private double ramNecessaria;

    // construtor com os 3 atributos do diagrama - RA: 25291321-2
    public Container(String id, String nomeApp, double ramNecessaria) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.ramNecessaria = ramNecessaria;
    }

    // getters usados pelo servidor e pelo main - RA: 25291321-2
    public String getId() {
        return id;
    }

    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // dois containers sao iguais se tiverem o mesmo id - RA: 25291321-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Container outro = (Container) obj;
        return id.equals(outro.id);
    }

    // hashCode feito so com o id, que e o campo que nao muda - RA: 25291321-2
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
