package com.example.sistemaBiblioteca.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um empréstimo de livro no sistema da biblioteca.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    /**
     * Identificador único do empréstimo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Data em que o livro foi emprestado.
     */
    private String dataEmprestimo;

    /**
     * Data prevista para devolução do livro.
     */
    private String dataDevolucao;
}
