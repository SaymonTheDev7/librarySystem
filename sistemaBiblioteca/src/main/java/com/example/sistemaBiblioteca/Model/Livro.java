package com.example.sistemaBiblioteca.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um livro no sistema de biblioteca.
 * Contém informações sobre o livro, como nome, gênero, autor e ano de publicação.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    /**
     * Identificador único do livro no sistema.
     * Este campo é gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do livro.
     * Representa o título do livro no sistema.
     */
    private String nome;

    /**
     * Gênero do livro.
     * Pode ser, por exemplo, ficção, não-ficção, fantasia, etc.
     */
    private String genero;

    /**
     * Autor do livro.
     * Representa o escritor responsável pela obra.
     */
    private String autor;

    /**
     * Ano de publicação do livro.
     * Representa o ano em que o livro foi publicado.
     */
    private int anoPublicacao;
}
