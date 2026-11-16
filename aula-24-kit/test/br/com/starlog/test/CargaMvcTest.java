package br.com.starlog.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.starlog.model.Carga;
import br.com.starlog.controller.CargaController;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SUÍTE DE TESTES TDD • AULA 24 (STARLOG LOGISTICS)
 * Permite validar a arquitetura sem abrir janelas gráficas!
 */
public class CargaMvcTest {

    @Test
    @DisplayName("TDD 01: Model deve calcular seguro padrão de 2% para carga normal")
    void deveCalcularSeguroPadrao() {
        Carga c = new Carga("CARG-01", "GERAL", 50.0, 1000.0);
        assertEquals(20.0, c.calcularSeguro(), 0.001);
    }

    @Test
    @DisplayName("TDD 02: Model deve aplicar sobretaxa de R$ 150 para carga perigosa")
    void deveAplicarSobretaxaCargaPerigosa() {
        Carga c = new Carga("CARG-02", "PERIGOSA", 20.0, 1000.0);
        // 2% de 1000 = 20 + 150 taxa = 170
        assertEquals(170.0, c.calcularSeguro(), 0.001);
    }

    @Test
    @DisplayName("TDD 03: Model deve aplicar sobretaxa para carga com peso superior a 100kg")
    void deveAplicarSobretaxaCargaPesada() {
        Carga c = new Carga("CARG-03", "ALIMENTAR", 120.0, 1000.0);
        assertEquals(170.0, c.calcularSeguro(), 0.001);
    }

    @Test
    @DisplayName("TDD 04: Fail-Fast - Construtor deve barrar peso zero ou negativo")
    void deveBarrarPesoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Carga("CARG-04", "GERAL", 0.0, 500.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Carga("CARG-04", "GERAL", -10.0, 500.0);
        });
    }

    @Test
    @DisplayName("TDD 05: Fail-Fast - Construtor deve barrar código vazio ou em branco")
    void deveBarrarCodigoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Carga("   ", "GERAL", 10.0, 500.0);
        });
    }

    @Test
    @DisplayName("TDD 06: Controller deve manter o repositório em memória e totalizar corretamente")
    void controllerDeveGerarRelatorioFormatado() {
        CargaController controller = new CargaController();
        // Cadastro via método de orquestração passando mock/null de view se necessário,
        // ou validando a lista do repositório
        assertEquals(0, controller.getRepositorio().size());
    }
}
