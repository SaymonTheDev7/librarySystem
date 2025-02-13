package com.example.sistemaBiblioteca.Repository;

import com.example.sistemaBiblioteca.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.jar.JarEntry;

@Repository
public interface AutorRepository extends JpaRepository <Autor, Integer> {
}
