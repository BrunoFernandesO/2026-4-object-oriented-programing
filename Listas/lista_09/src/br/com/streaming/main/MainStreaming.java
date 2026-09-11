package br.com.streaming.main;

import br.com.streaming.model.Usuario;
import br.com.streaming.model.Video;

public class MainStreaming {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Bruno", "bruno@email.com", true);
        Video v1 = new Video("Documentario Java", 120);
        Video v2 = new Video("Trailer Bugado", -45);

        System.out.println(usuario);
        System.out.println("Duracao do segundo video: " + v2.getDuracaoMinutos());
    }
}
