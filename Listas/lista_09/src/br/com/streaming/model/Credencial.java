package br.com.streaming.model;

public class Credencial {
    private String codigoHex;

    public Credencial(String codigoHex) {
        this.codigoHex = codigoHex;
    }

    public String getCodigoHex() {
        return codigoHex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Credencial outra = (Credencial) obj;
        return codigoHex.equals(outra.codigoHex);
    }

    @Override
    public int hashCode() {
        return codigoHex.hashCode();
    }
}
