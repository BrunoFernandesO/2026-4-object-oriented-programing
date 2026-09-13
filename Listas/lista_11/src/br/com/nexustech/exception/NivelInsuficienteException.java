package br.com.nexustech.exception;

public class NivelInsuficienteException extends RuntimeException {
    public NivelInsuficienteException() {
        super("Seu nivel e muito baixo para esta masmorra!");
    }
}
