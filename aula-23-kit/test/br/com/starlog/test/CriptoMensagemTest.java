package br.com.starlog.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

// Estes imports apontam para as classes que os alunos devem construir na refatoração:
import br.com.starlog.model.CriptoMensagem;
import br.com.starlog.controller.TransmissaoController;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SUÍTE OFICIAL DE HOMOLOGAÇÃO TDD (StarLog Protocol 11)
 * Os alunos devem fazer TODOS os testes desta suíte passarem (Barra Verde)!
 */
public class CriptoMensagemTest {

    @Test
    @DisplayName("TDD 01: Model deve cifrar mensagem com chave de deslocamento válida")
    void deveCifrarMensagemComChaveValida() {
        // Arrange
        CriptoMensagem cripto = new CriptoMensagem("APOLLO", "JAVA", 3);

        // Act
        String textoCifrado = cripto.cifrar();

        // Assert: J + 3 = M, A + 3 = D, V + 3 = Y, A + 3 = D -> MDYD
        assertEquals("MDYD", textoCifrado);
    }

    @Test
    @DisplayName("TDD 02: Model deve preservar espaços e pontuação na cifra")
    void devePreservarEspacosEPontuacao() {
        // Arrange
        CriptoMensagem cripto = new CriptoMensagem("BASE-01", "POO 2026!", 1);

        // Act
        String textoCifrado = cripto.cifrar();

        // Assert: P+1=Q, O+1=P, O+1=P, espaço e pontuação inalterados -> QPP 2026!
        assertEquals("QPP 2026!", textoCifrado);
    }

    @Test
    @DisplayName("TDD 03: Model deve aplicar rotação circular do alfabeto (Wrap-around)")
    void deveAplicarRotacaoCircularNoAlfabeto() {
        // Arrange: Z com deslocamento 1 deve virar A
        CriptoMensagem cripto = new CriptoMensagem("FROTA", "XYZ", 1);

        // Act & Assert
        assertEquals("YZA", cripto.cifrar());
    }

    @Test
    @DisplayName("TDD 04: Model deve calcular checksum baseado na soma dos caracteres ASCII")
    void deveCalcularChecksumCorreto() {
        // Arrange: 'A' (65) + 'B' (66) = 131
        CriptoMensagem cripto = new CriptoMensagem("PILOTO", "AB", 2);

        // Act
        int checksum = cripto.calcularChecksum();

        // Assert
        assertEquals(131, checksum);
    }

    @Test
    @DisplayName("TDD 05: Fail-Fast - Construtor deve barrar remetente nulo ou em branco")
    void deveLancarExcecaoQuandoRemetenteInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CriptoMensagem("   ", "MENSAGEM", 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new CriptoMensagem(null, "MENSAGEM", 3);
        });
    }

    @Test
    @DisplayName("TDD 06: Fail-Fast - Construtor deve barrar chave de deslocamento fora de 1..25")
    void deveLancarExcecaoQuandoChaveForaDoIntervalo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CriptoMensagem("ALPHA", "MENSAGEM", 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new CriptoMensagem("ALPHA", "MENSAGEM", 26);
        });
    }

    @Test
    @DisplayName("TDD 07: Controller deve formatar o pacote final transmitido corretamente")
    void controllerDeveGerarPacoteFinalFormatado() {
        // Arrange
        TransmissaoController controller = new TransmissaoController();

        // Act: Remetente "BASE", Msg "OLA", Chave "2" (O+2=Q, L+2=N, A+2=C -> QNC)
        // Checksum de O (79) + L (76) + A (65) = 220
        String pacote = controller.processarTransmissao("BASE", "OLA", "2");

        // Assert: [BASE] #220 -> QNC
        assertEquals("[BASE] #220 -> QNC", pacote);
        assertEquals(1, controller.getTotalTransmissoes());
    }

    @Test
    @DisplayName("TDD 08: Controller deve barrar chave não numérica capturando NumberFormatException")
    void controllerDeveRejeitarChaveNaoNumerica() {
        TransmissaoController controller = new TransmissaoController();

        // Deve lançar IllegalArgumentException com mensagem amigável quando chave não for número
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            controller.processarTransmissao("BASE", "OLA", "abc");
        });
        assertTrue(ex.getMessage().contains("Chave deve ser um número"));
    }
}
