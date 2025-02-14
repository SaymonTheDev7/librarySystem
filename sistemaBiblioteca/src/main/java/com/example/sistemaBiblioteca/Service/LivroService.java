package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Livro;
import com.example.sistemaBiblioteca.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de negócios relacionada aos livros no sistema de biblioteca.
 * Contém métodos para criar, atualizar, deletar e buscar livros.
 */
@Service
public class LivroService {

    /**
     * Repositório que realiza as operações no banco de dados para a entidade Livro.
     */
    @Autowired
    LivroRepository livroRepository;

    /**
     * Cria um novo livro no sistema.
     *
     * @param livro O objeto Livro a ser criado.
     * @return O livro criado, incluindo o ID gerado automaticamente.
     */
    public Livro criarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    /**
     * Atualiza os dados de um livro existente no sistema.
     *
     * @param id O ID do livro a ser atualizado.
     * @param livro O objeto Livro com os novos dados.
     * @return O livro atualizado.
     */
    public Livro atualizarLivro(Integer id, Livro livro) {
        return livroRepository.save(livro);
    }

    /**
     * Deleta um livro do sistema com base no ID fornecido.
     *
     * @param id O ID do livro a ser deletado.
     */
    public void deletarLivro(Integer id) {
        livroRepository.deleteById(id);
    }

    /**
     * Busca um livro no sistema com base no ID fornecido.
     *
     * @param id O ID do livro a ser buscado.
     * @return O livro encontrado, ou uma exceção se o livro não for encontrado.
     */
    public Livro buscarLivro(Integer id) {
        return livroRepository.findById(id).get();
    }
}
