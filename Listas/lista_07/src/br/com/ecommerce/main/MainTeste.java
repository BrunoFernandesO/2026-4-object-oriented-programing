package br.com.ecommerce.main;

import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.FreteMotoboy;
import br.com.ecommerce.model.FretePac;
import br.com.ecommerce.model.FreteSedex;
import br.com.ecommerce.exception.TipoFreteInvalidoException;

public class MainTeste {
    public static void main(String[] args) {
        CalculadoraFrete calc = new CalculadoraFrete();

        try {
            System.out.println("Sedex: " + calc.processarFrete(100.00, new FreteSedex()));
            System.out.println("Pac: " + calc.processarFrete(100.00, new FretePac()));
            System.out.println("Motoboy: " + calc.processarFrete(100.00, new FreteMotoboy()));

            System.out.println("Frete nulo: " + calc.processarFrete(100.00, null));
        } catch (TipoFreteInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
