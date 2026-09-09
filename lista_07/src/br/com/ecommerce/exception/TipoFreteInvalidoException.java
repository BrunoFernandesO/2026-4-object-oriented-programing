package br.com.ecommerce.exception;

public class TipoFreteInvalidoException extends RuntimeException {
    public TipoFreteInvalidoException(String mensagem) {
        super(mensagem);
    }
}
