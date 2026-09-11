package br.com.streaming.main;

import br.com.streaming.model.Usuario;

public class MainMemoria {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", "ana@email.com", true);
        Usuario u2 = new Usuario("Ana Paula", "ana@email.com", false);

        if (u1.equals(u2)) {
            System.out.println("Usuarios logicamente iguais (mesmo email).");
        } else {
            System.out.println("Usuarios diferentes.");
        }

        System.out.println("Plataforma: " + Usuario.PLATAFORMA);
        System.out.println("Total de usuarios: " + Usuario.getTotalUsuarios());
    }
}
