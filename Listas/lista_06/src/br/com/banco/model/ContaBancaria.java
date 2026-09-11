package br.com.banco.model;

public class ContaBancaria {
    private String numero;
    private Cliente titular;
    private double saldo;

    public ContaBancaria(String numero, Cliente titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        Agencia.registrarNovaConta();
    }

    public boolean sacar(double valor) {
        if (saldo >= valor + Agencia.TAXA_SAQUE) {
            saldo = saldo - (valor + Agencia.TAXA_SAQUE);
            return true;
        }
        return false;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
