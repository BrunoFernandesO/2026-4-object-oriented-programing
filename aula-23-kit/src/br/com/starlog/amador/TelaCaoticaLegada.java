package br.com.starlog.amador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * CÓDIGO LEGADO CORROMPIDO • ESTAÇÃO STARLOG-ZERO
 * 
 * ALERTA DE ARQUITETURA: Este arquivo é um exemplo CLÁSSICO de código macarrônico amador!
 * Ele viola o Princípio da Responsabilidade Única (SRP) e o padrão MVC.
 * Tudo está misturado: criação visual, validações, cálculo de criptografia e persistência em memória.
 * 
 * MISSÃO DO SQUAD:
 * Resgatar as regras deste arquivo e refatorar criando o Model (CriptoMensagem) 
 * e o Controller (TransmissaoController), fazendo a suíte de testes TDD acender a barra VERDE!
 */
public class TelaCaoticaLegada extends JFrame {

    private JTextField txtRemetente;
    private JTextField txtMensagem;
    private JTextField txtChaveCifra;
    private JButton btnDespacharCifrado;
    private JTextArea areaLog;

    // "Banco de dados" misturado diretamente dentro da janela!
    private List<String> historicoDisparos = new ArrayList<>();

    public TelaCaoticaLegada() {
        super("SISTEMA LEGADO CORROMPIDO - STARLOG");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Remetente da Frota:"));
        txtRemetente = new JTextField(20);
        add(txtRemetente);

        add(new JLabel("Mensagem Secreta:"));
        txtMensagem = new JTextField(20);
        add(txtMensagem);

        add(new JLabel("Chave de Deslocamento (César 1 a 25):"));
        txtChaveCifra = new JTextField(5);
        add(txtChaveCifra);

        btnDespacharCifrado = new JButton("Cifrar e Transmitir");
        add(btnDespacharCifrado);

        areaLog = new JTextArea(10, 35);
        add(new JScrollPane(areaLog));

        // =========================================================================
        // O MONSTRO DO BOTAO: Mais de 60 linhas misturando tudo dentro do evento!
        // =========================================================================
        btnDespacharCifrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Coleta direta da tela
                String remetente = txtRemetente.getText();
                String msg = txtMensagem.getText();
                String chaveStr = txtChaveCifra.getText();

                // 2. Validações primitivas misturadas com JOptionPane
                if (remetente == null || remetente.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERRO: Remetente não pode ser vazio!");
                    return;
                }
                if (msg == null || msg.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERRO: Mensagem não pode ser vazia!");
                    return;
                }

                // 3. Conversão de tipo no meio da tela com risco de quebra
                int deslocamento = 0;
                try {
                    deslocamento = Integer.parseInt(chaveStr.trim());
                    if (deslocamento < 1 || deslocamento > 25) {
                        JOptionPane.showMessageDialog(null, "ERRO: Chave deve estar entre 1 e 25!");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: Chave deve ser um número inteiro!");
                    return;
                }

                // 4. REGRA DE NEGÓCIO PESADA: Criptografia Cifra de César rodando dentro do botão!
                StringBuilder cifrado = new StringBuilder();
                String textoLimpo = msg.trim().toUpperCase();
                for (int i = 0; i < textoLimpo.length(); i++) {
                    char c = textoLimpo.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        char letraCifrada = (char) ('A' + (c - 'A' + deslocamento) % 26);
                        cifrado.append(letraCifrada);
                    } else {
                        cifrado.append(c); // Mantém espaços e pontuações
                    }
                }

                // 5. REGRA DE ASSINATURA: Hash de verificação simples concatenado
                int checksum = 0;
                for (char c : textoLimpo.toCharArray()) {
                    checksum += (int) c;
                }
                String pacoteFinal = String.format("[%s] #%d -> %s", remetente.trim().toUpperCase(), checksum, cifrado.toString());

                // 6. Persistência direta em memória acoplada na tela
                historicoDisparos.add(pacoteFinal);
                areaLog.append(pacoteFinal + "\n");
                JOptionPane.showMessageDialog(null, "Transmissão efetuada com sucesso!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCaoticaLegada().setVisible(true));
    }
}
