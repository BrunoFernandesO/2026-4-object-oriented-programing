package br.com.ecommerce.model;

public class FreteSedex implements EstrategiaFrete {
    public double calcular(double valorPedido) {
        return valorPedido * 0.10;
    }
}
