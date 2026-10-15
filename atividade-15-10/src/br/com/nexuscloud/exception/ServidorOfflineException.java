package br.com.nexuscloud.exception;

// excecao unchecked (estende RuntimeException), entao nao precisa de throws nem try-catch obrigatorio - RA: 25291321-2
public class ServidorOfflineException extends RuntimeException {

    // construtor recebe a mensagem e repassa pro RuntimeException guardar - RA: 25291321-2
    public ServidorOfflineException(String msg) {
        super(msg);
    }
}
