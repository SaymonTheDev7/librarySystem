package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Autor;
import com.example.sistemaBiblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService  {

    @Autowired
    AutorRepository autorRepository;

    public Autor criarAutor (Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletarAutor (Integer id) {
        autorRepository.deleteById(id);
    }

    public Autor buscarAutor (Integer id) {
        return autorRepository.findById(id).get();
    }

    public Autor atualizarAutor (Integer id, Autor autor) {
        return autorRepository.save(autor);
    }
}
