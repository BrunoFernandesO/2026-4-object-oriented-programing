package br.com.starlog.controller;

import br.com.starlog.model.Carga;
import br.com.starlog.view.TelaCadastroCarga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CAMADA CONTROLLER (O Maestro da Aplicação)
 * Responsável por:
 * 1. Fazer o parse de String para double dos dados vindos da tela.
 * 2. Tratar NumberFormatException caso o usuário digite texto em campos numéricos.
 * 3. Instanciar a Carga e capturar IllegalArgumentException de regras de negócio.
 * 4. Manter a lista de cargas na memória.
 * 5. Notificar a View para exibir feedback limpo ao usuário.
 */
public class CargaController {

    private final List<Carga> repositorio = new ArrayList<>();

    /**
     * Processa o cadastro de uma nova carga vinda da View.
     *
     * @param codigoRaw    Código digitado no JTextField
     * @param categoriaRaw Categoria selecionada no JComboBox
     * @param pesoRaw      Texto do peso digitado no JTextField
     * @param valorRaw     Texto do valor declarado no JTextField
     * @param tela         Referência da View para disparar avisos e atualizar tela
     */
    public void cadastrarCarga(String codigoRaw, String categoriaRaw, String pesoRaw, String valorRaw, TelaCadastroCarga tela) {
        try {
            if (pesoRaw == null) {
                pesoRaw = "";
            }
            if (valorRaw == null) {
                valorRaw = "";
            }
            double peso = Double.parseDouble(pesoRaw.replace(",", "."));
            double valor = Double.parseDouble(valorRaw.replace(",", "."));

            Carga novaCarga = new Carga(codigoRaw, categoriaRaw, peso, valor);
            this.repositorio.add(novaCarga);

            tela.exibirMensagemSucesso("Carga cadastrada com sucesso!\n" + novaCarga.toString());
            tela.atualizarRelatorio(gerarTextoRelatorio());
        } catch (NumberFormatException e) {
            tela.exibirMensagemErro("Erro de formato numérico: Digite apenas números válidos para Peso e Valor!");
        } catch (IllegalArgumentException e) {
            tela.exibirMensagemErro("Regra de Negócio Violada: " + e.getMessage());
        }
    }

    /**
     * Retorna a lista de cargas como texto formatado para exibição na JTextArea da View.
     */
    public String gerarTextoRelatorio() {
        if (repositorio.isEmpty()) {
            return "Nenhuma carga registrada na esteira.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO OFICIAL DE DESPACHO ---\n");
        double totalSeguro = 0.0;
        double pesoTotal = 0.0;

        for (int i = 0; i < repositorio.size(); i++) {
            Carga c = repositorio.get(i);
            sb.append(String.format("%02d. %s\n", (i + 1), c.toString()));
            totalSeguro += c.calcularSeguro();
            pesoTotal += c.getPeso();
        }

        sb.append("-------------------------------------\n");
        sb.append(String.format("Total de Cargas: %d | Peso Total: %.2f kg | Seguro Acumulado: R$ %.2f\n",
                repositorio.size(), pesoTotal, totalSeguro));

        return sb.toString();
    }

    public List<Carga> getRepositorio() {
        return Collections.unmodifiableList(repositorio);
    }
}
