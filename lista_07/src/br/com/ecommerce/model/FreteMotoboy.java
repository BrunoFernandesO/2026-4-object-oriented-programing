package br.com.ecommerce.model;

public class FreteMotoboy implements EstrategiaFrete {
    public double calcular(double valorPedido) {
        return 15.00;
    }
}
