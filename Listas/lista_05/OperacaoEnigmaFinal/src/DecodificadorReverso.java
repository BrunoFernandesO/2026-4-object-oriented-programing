public class DecodificadorReverso implements Decodificador {

    public String decodificar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }
}
