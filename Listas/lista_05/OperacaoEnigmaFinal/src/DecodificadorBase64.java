import java.util.Base64;

public class DecodificadorBase64 implements Decodificador {

    public String decodificar(String texto) {
        byte[] bytes = Base64.getDecoder().decode(texto.trim());
        return new String(bytes);
    }
}
