package com.example.sistemaBiblioteca.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um autor no sistema da biblioteca.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    /**
     * Identificador único do autor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do autor.
     */
    private String nome;

    /**
     * Nacionalidade do autor.
     */
    private String nacionalidade;

    /**
     * Data de nascimento do autor.
     */
    private String dataNascimento;

    /**
     * Biografia do autor.
     */
    private String biografia;

    /**
     * Gênero literário principal do autor.
     */
    private String genero;
}
