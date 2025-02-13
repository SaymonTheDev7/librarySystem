package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Usuario;
import com.example.sistemaBiblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criarUsuario (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario (Integer id, Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario (Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarUsuario (Integer id) {
        return usuarioRepository.findById(id).get();
    }
}
