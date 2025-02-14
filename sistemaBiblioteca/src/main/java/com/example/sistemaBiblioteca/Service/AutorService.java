package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Autor;
import com.example.sistemaBiblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de negócios relacionada aos autores no sistema de biblioteca.
 * Contém métodos para criar, deletar, buscar e atualizar autores.
 */
@Service
public class AutorService {

    /**
     * Repositório que realiza as operações no banco de dados para a entidade Autor.
     */
    @Autowired
    AutorRepository autorRepository;

    /**
     * Cria um novo autor no sistema.
     *
     * @param autor O objeto Autor a ser criado.
     * @return O autor criado, incluindo o ID gerado automaticamente.
     */
    public Autor criarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Deleta um autor do sistema com base no ID fornecido.
     *
     * @param id O ID do autor a ser deletado.
     */
    public void deletarAutor(Integer id) {
        autorRepository.deleteById(id);
    }

    /**
     * Busca um autor no sistema com base no ID fornecido.
     *
     * @param id O ID do autor a ser buscado.
     * @return O autor encontrado, ou uma exceção se o autor não for encontrado.
     */
    public Autor buscarAutor(Integer id) {
        return autorRepository.findById(id).get();
    }

    /**
     * Atualiza os dados de um autor existente no sistema.
     *
     * @param id O ID do autor a ser atualizado.
     * @param autor O objeto Autor com os novos dados.
     * @return O autor atualizado.
     */
    public Autor atualizarAutor(Integer id, Autor autor) {
        return autorRepository.save(autor);
    }
}
