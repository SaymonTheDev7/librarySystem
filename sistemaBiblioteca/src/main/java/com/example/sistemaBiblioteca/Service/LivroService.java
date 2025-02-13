package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Livro;
import com.example.sistemaBiblioteca.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public Livro criarLivro (Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro (Integer id, Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletarLivro (Integer id) {
        livroRepository.deleteById(id);
    }

    public Livro buscarLivro (Integer id) {
        return livroRepository.findById(id).get();
    }
}
