package com.example.sistemaBiblioteca.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um usuário do sistema de biblioteca.
 * Contém informações essenciais sobre o usuário, como nome, email e senha.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    /**
     * Identificador único do usuário no sistema.
     * Este campo é gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome completo do usuário.
     * Representa o nome utilizado para identificação no sistema.
     */
    private String nome;

    /**
     * Endereço de email do usuário.
     * Usado para autenticação e comunicação com o usuário.
     */
    private String email;

    /**
     * Senha do usuário.
     * Usada para autenticação e segurança do acesso ao sistema.
     */
    private String senha;
}
