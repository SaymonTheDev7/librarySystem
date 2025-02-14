package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Usuario;
import com.example.sistemaBiblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de negócios relacionada aos usuários no sistema de biblioteca.
 * Contém métodos para criar, atualizar, deletar e buscar usuários.
 */
@Service
public class UsuarioService {

    /**
     * Repositório que realiza as operações no banco de dados para a entidade Usuario.
     */
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Cria um novo usuário no sistema.
     *
     * @param usuario O objeto Usuario a ser criado.
     * @return O usuário criado, incluindo o ID gerado automaticamente.
     */
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza os dados de um usuário existente no sistema.
     *
     * @param id O ID do usuário a ser atualizado.
     * @param usuario O objeto Usuario com os novos dados.
     * @return O usuário atualizado.
     */
    public Usuario atualizarUsuario(Integer id, Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Deleta um usuário do sistema com base no ID fornecido.
     *
     * @param id O ID do usuário a ser deletado.
     */
    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Busca um usuário no sistema com base no ID fornecido.
     *
     * @param id O ID do usuário a ser buscado.
     * @return O usuário encontrado, ou uma exceção se o usuário não for encontrado.
     */
    public Usuario buscarUsuario(Integer id) {
        return usuarioRepository.findById(id).get();
    }
}
