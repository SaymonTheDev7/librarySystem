package com.example.sistemaBiblioteca.Repository;

import com.example.sistemaBiblioteca.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
