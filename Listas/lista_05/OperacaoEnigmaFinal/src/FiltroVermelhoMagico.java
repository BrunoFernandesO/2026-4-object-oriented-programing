import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FiltroVermelhoMagico implements FiltroImagem {

    public void aplicarFiltro(String caminhoEntrada, String caminhoSaida) {
        try {
            BufferedImage img = ImageIO.read(new File(caminhoEntrada));
            int largura = img.getWidth();
            int altura = img.getHeight();
            BufferedImage saida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            int preto = 0x000000;
            int branco = 0xFFFFFF;
            for (int y = 0; y < altura; y++) {
                for (int x = 0; x < largura; x++) {
                    int rgb = img.getRGB(x, y);
                    int vermelho = (rgb >> 16) & 0xFF;
                    if (vermelho % 2 == 1) {
                        saida.setRGB(x, y, preto);
                    } else {
                        saida.setRGB(x, y, branco);
                    }
                }
            }
            ImageIO.write(saida, "png", new File(caminhoSaida));
            System.out.println("Imagem gerada em: " + caminhoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao processar imagem: " + e.getMessage());
        }
    }
}
