package br.com.streaming.model;

public class PagamentoPix implements Pagamento {
    public void processar(double valor) {
        System.out.println("Gerando QR Code Pix no valor de R$ " + valor);
    }
}
