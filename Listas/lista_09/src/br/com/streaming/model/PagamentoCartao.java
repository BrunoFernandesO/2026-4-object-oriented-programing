package br.com.streaming.model;

public class PagamentoCartao implements Pagamento {
    public void processar(double valor) {
        System.out.println("Validando limite no cartao para cobranca de R$ " + valor);
    }
}
