package br.com.starlog.controller;

import br.com.starlog.model.CriptoMensagem;
import java.util.ArrayList;
import java.util.List;

/**
 * CAMADA CONTROLLER (O Maestro da Transmissão)
 * 
 * ATENÇÃO ESTUDANTE:
 * Implemente esta classe para orquestrar as requisições da View,
 * convertendo os tipos brutos e alimentando o Model!
 * 
 * REGRA DE ARQUITETURA:
 * O Controller manipula lógica e dados, NÃO componentes visuais (zero imports de javax.swing.*)!
 */
public class TransmissaoController {

    private final List<String> bufferTransmissoes = new ArrayList<>();

    /**
     * Orquestra a transmissão da mensagem.
     * 
     * @param remetenteRaw Remetente vindo do campo de texto da tela
     * @param msgRaw       Mensagem vinda do campo de texto da tela
     * @param chaveStr     Chave digitada como texto na tela
     * @return Pacote formatado no padrão: [REMETENTE] #CHECKSUM -> TEXTO_CIFRADO
     */
    public String processarTransmissao(String remetenteRaw, String msgRaw, String chaveStr) {
        int chave;
        try {
            chave = Integer.parseInt(chaveStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Chave deve ser um número inteiro válido.");
        }
        CriptoMensagem cripto = new CriptoMensagem(remetenteRaw, msgRaw, chave);
        String textoCifrado = cripto.cifrar();
        int checksum = cripto.calcularChecksum();
        String pacote = String.format("[%s] #%d -> %s", cripto.getRemetente(), checksum, textoCifrado);
        bufferTransmissoes.add(pacote);
        return pacote;
    }

    public int getTotalTransmissoes() {
        return bufferTransmissoes.size();
    }
}
