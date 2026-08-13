package br.com.mysystem.main;
import br.com.mysystem.model.Carro;

public class Sistema{
    public static void main(String[] args){
        System.out.println("Inicializando o sistema...");
        Carro myCar = new Carro();
        myCar.modelo = "Fusca";
        myCar.cor = "Azul";
        myCar.buzinar();
        // Agora a minha vez
        Carro carro2 = new Carro();
        carro2.modelo = "Dodge RAM 1500";
        carro2.cor = "Preta";
        carro2.buzinar();   
    }
}
