package br.com.nexuscloud.exception;

// excecao checked (estende Exception), quem chamar o metodo e obrigado a tratar com try-catch ou repassar com throws - RA: 25291321-2
public class CapacidadeExcedidaException extends Exception {

    // construtor recebe a mensagem e manda pro construtor da classe Exception - RA: 25291321-2
    public CapacidadeExcedidaException(String msg) {
        super(msg);
    }
}
