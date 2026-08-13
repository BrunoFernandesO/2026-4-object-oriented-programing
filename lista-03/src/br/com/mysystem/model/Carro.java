package br.com.mysystem.model;

public class Carro {
    public String modelo;
    public String cor;
    
    public void buzinar(){
        System.out.println("O " + modelo + " " + cor + " fez: BIIII BIIII!");
    }
}
