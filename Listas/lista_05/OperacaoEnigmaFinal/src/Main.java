import java.io.File;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("=== Operacao Enigma ===");

        byte[] dados = Files.readAllBytes(new File("pista_01.jpg").toPath());
        int fim = -1;
        for (int i = 0; i < dados.length - 1; i++) {
            if ((dados[i] & 0xFF) == 0xFF && (dados[i + 1] & 0xFF) == 0xD9) {
                fim = i + 2;
            }
        }
        String oculto = new String(dados, fim, dados.length - fim).trim();
        System.out.println("Base64 oculto: " + oculto);

        Decodificador base64 = new DecodificadorBase64();
        String instrucao = base64.decodificar(oculto);
        System.out.println("Instrucao decodificada: " + instrucao);

        int chave = 0;
        String[] partes = instrucao.split(" ");
        for (int i = 0; i < partes.length; i++) {
            if (partes[i].equals("|")) {
                chave = Integer.parseInt(partes[i - 1]);
            }
        }
        System.out.println("Chave Cesar: " + chave);

        String mensagem = new String(Files.readAllBytes(new File("mensagem.txt").toPath()));
        Decodificador cesar = new DecodificadorCesar(chave);
        String ordem = cesar.decodificar(mensagem);
        System.out.println("Mensagem revelada: " + ordem);

        FiltroImagem filtro = new FiltroVermelhoMagico();
        filtro.aplicarFiltro("ruido.bmp", "resultado.png");

        System.out.println("Abra resultado.png para ver a URL secreta.");
    }
}
