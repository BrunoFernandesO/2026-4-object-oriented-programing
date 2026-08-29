package br.com.mysystem.model;

public class Carro {
    private String modelo;
    private String cor;
    private int velocidade;
    
    public void setVelocidade(int velocidade) {
        if(velocidade < 0){
            System.out.println("Erro! Velocidade não pode ser negativa.");
        } else{
            this.velocidade = velocidade;
        }
    } 

    public void buzinar(){
        System.out.println("O " + modelo + " " + cor + " fez: BIIII BIIII!");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade() {
        return velocidade;
    }


    
}
