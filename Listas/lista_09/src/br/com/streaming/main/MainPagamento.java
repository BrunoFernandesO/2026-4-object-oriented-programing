package br.com.streaming.main;

import br.com.streaming.model.Pagamento;
import br.com.streaming.model.PagamentoCartao;
import br.com.streaming.model.PagamentoPix;
import br.com.streaming.model.ProcessadorPagamento;

public class MainPagamento {
    public static void main(String[] args) {
        ProcessadorPagamento processador = new ProcessadorPagamento();

        Pagamento pix = new PagamentoPix();
        Pagamento cartao = new PagamentoCartao();

        processador.finalizarCompra(99.90, pix);
        processador.finalizarCompra(199.90, cartao);
    }
}
