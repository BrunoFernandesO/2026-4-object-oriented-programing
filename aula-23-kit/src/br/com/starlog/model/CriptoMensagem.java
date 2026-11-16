package br.com.starlog.model;

/**
 * CAMADA MODEL (Modelo de Domínio)
 * Representa uma mensagem criptográfica a ser transmitida.
 * 
 * ATENÇÃO ESTUDANTE:
 * Implemente esta classe a partir do código extraído da TelaCaoticaLegada
 * para satisfazer os testes TDD de 01 a 06!
 * 
 * REGRA SAGRADA DE ARQUITETURA:
 * O Model NUNCA deve importar componentes visuais (zero imports de javax.swing.*)!
 */
public class CriptoMensagem {
    private final String remetente;
    private final String mensagem;
    private final int chaveDeslocamento;

    public CriptoMensagem(String remetente, String mensagem, int chaveDeslocamento) {
        if (remetente == null || remetente.trim().isEmpty()) {
            throw new IllegalArgumentException("Remetente não pode ser nulo ou vazio.");
        }
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia.");
        }
        if (chaveDeslocamento < 1 || chaveDeslocamento > 25) {
            throw new IllegalArgumentException("Chave deve estar entre 1 e 25.");
        }
        this.remetente = remetente.trim().toUpperCase();
        this.mensagem = mensagem.trim().toUpperCase();
        this.chaveDeslocamento = chaveDeslocamento;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getChaveDeslocamento() {
        return chaveDeslocamento;
    }

    /**
     * Aplica o algoritmo da Cifra de César com deslocamento circular ('A'..'Z').
     * Preserva espaços e pontuações sem alteração.
     */
    public String cifrar() {
        String resultado = "";
        for (int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char cifrado = (char) ('A' + (c - 'A' + this.chaveDeslocamento) % 26);
                resultado = resultado + cifrado;
            } else {
                resultado = resultado + c;
            }
        }
        return resultado;
    }

    /**
     * Calcula o checksum somando o valor ordinal ASCII de cada caractere da mensagem em maiúsculo.
     */
    public int calcularChecksum() {
        int soma = 0;
        for (int i = 0; i < mensagem.length(); i++) {
            soma += mensagem.charAt(i);
        }
        return soma;
    }
}
