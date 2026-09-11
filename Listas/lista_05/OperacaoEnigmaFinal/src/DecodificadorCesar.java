public class DecodificadorCesar implements Decodificador {

    private int chave;

    public DecodificadorCesar(int chave) {
        this.chave = chave;
    }

    public String decodificar(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' - chave + 26) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' - chave + 26) % 26 + 'A');
            }
            resultado = resultado + c;
        }
        return resultado;
    }
}
