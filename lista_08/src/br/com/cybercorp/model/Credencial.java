package br.com.cybercorp.model;

public class Credencial {
    private String codigoHex;
    private boolean ativa;
    private Funcionario titular;

    public Credencial(String codigoHex, boolean ativa, Funcionario titular) {
        this.codigoHex = codigoHex;
        this.ativa = ativa;
        this.titular = titular;
    }

    public String getCodigoHex() {
        return codigoHex;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public Funcionario getTitular() {
        return titular;
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
