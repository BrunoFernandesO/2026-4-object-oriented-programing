package br.com.bookstore.dao;

import br.com.bookstore.model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroDAO {
    void salvar(Livro livro);
    Optional<Livro> buscarPorId(Long id);
    List<Livro> listarTodos();
}
