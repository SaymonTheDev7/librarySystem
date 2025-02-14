package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Emprestimo;
import com.example.sistemaBiblioteca.Repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de negócios relacionada aos empréstimos no sistema de biblioteca.
 * Contém métodos para criar, atualizar, deletar e buscar empréstimos.
 */
@Service
public class EmprestimoService {

    /**
     * Repositório que realiza as operações no banco de dados para a entidade Emprestimo.
     */
    @Autowired
    EmprestimoRepository emprestimoRepository;

    /**
     * Cria um novo empréstimo no sistema.
     *
     * @param emprestimo O objeto Emprestimo a ser criado.
     * @return O empréstimo criado, incluindo o ID gerado automaticamente.
     */
    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    /**
     * Atualiza os dados de um empréstimo existente no sistema.
     *
     * @param id O ID do empréstimo a ser atualizado.
     * @param emprestimo O objeto Emprestimo com os novos dados.
     * @return O empréstimo atualizado.
     */
    public Emprestimo atualizarEmprestimo(Integer id, Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    /**
     * Deleta um empréstimo do sistema com base no ID fornecido.
     *
     * @param id O ID do empréstimo a ser deletado.
     */
    public void deletarEmprestimo(Integer id) {
        emprestimoRepository.deleteById(id);
    }

    /**
     * Busca um empréstimo no sistema com base no ID fornecido.
     *
     * @param id O ID do empréstimo a ser buscado.
     * @return O empréstimo encontrado, ou uma exceção se o empréstimo não for encontrado.
     */
    public Emprestimo buscarEmprestimo(Integer id) {
        return emprestimoRepository.findById(id).get();
    }
}
