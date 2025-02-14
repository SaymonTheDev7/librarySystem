package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Livro;
import com.example.sistemaBiblioteca.Service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsável por gerenciar operações relacionadas a livros no sistema da biblioteca.
 */
@RestController
@RequestMapping("api/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    /**
     * Cria um novo livro.
     *
     * @param livro Objeto contendo as informações do livro.
     * @return ResponseEntity contendo o livro criado e o status HTTP 201 (Created).
     */
    @PostMapping("/criarlivro")
    @Operation(summary = "Cria um novo livro", description = "Cria um novo livro")
    @Tag(name = "Livro", description = "Operações relacionadas aos livros")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao criar livro")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Livro> criarLivro(
            @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody
            @Parameter(description = "Informações do livro", required = true,
                    content = @Content(schema = @Schema(implementation = Livro.class),
                            examples = @ExampleObject(value = "{\"titulo\": \"Livro 1\", \"autor\": \"Autor 1\"}"))) Livro livro) {
        return new ResponseEntity<>(livroService.criarLivro(livro), HttpStatus.CREATED);
    }

    /**
     * Deleta um livro pelo ID.
     *
     * @param id Identificador do livro a ser deletado.
     * @return ResponseEntity contendo a mensagem de sucesso e o status HTTP 200 (OK).
     */
    @DeleteMapping("/deletarlivro/{id}")
    @Operation(summary = "Deleta um livro", description = "Deleta um livro")
    @Tag(name = "Livro", description = "Operações relacionadas aos livros")
    @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> deletarLivro(
            @PathVariable
            @Parameter(description = "ID do livro", required = true,
                    content = @Content(examples = @ExampleObject(value = "1"))) Integer id) {
        livroService.deletarLivro(id);
        return new ResponseEntity<>("Livro deletado com sucesso", HttpStatus.OK);
    }

    /**
     * Atualiza um livro pelo ID.
     *
     * @param id Identificador do livro a ser atualizado.
     * @param livro Objeto contendo as novas informações do livro.
     * @return ResponseEntity contendo o livro atualizado e o status HTTP 200 (OK).
     */
    @PutMapping("/atualizarlivro/{id}")
    @Operation(summary = "Atualiza um livro", description = "Atualiza um livro")
    @Tag(name = "Livro", description = "Operações relacionadas aos livros")
    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Livro> atualizarLivro(
            @PathVariable
            @Parameter(description = "ID do livro", required = true,
                    content = @Content(examples = @ExampleObject(value = "1"))) Integer id,
            @RequestBody Livro livro) {
        return new ResponseEntity<>(livroService.atualizarLivro(id, livro), HttpStatus.OK);
    }

    /**
     * Busca um livro pelo ID.
     *
     * @param id Identificador do livro a ser buscado.
     * @return ResponseEntity contendo o livro encontrado e o status HTTP 200 (OK).
     */
    @GetMapping("/buscarlivro/{id}")
    @Operation(summary = "Busca um livro", description = "Busca um livro")
    @Tag(name = "Livro", description = "Operações relacionadas aos livros")
    @ApiResponse(responseCode = "200", description = "Livro encontrado")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Livro> buscarLivro(
            @PathVariable
            @Parameter(description = "ID do livro", required = true,
                    content = @Content(examples = @ExampleObject(value = "1"))) Integer id) {
        return new ResponseEntity<>(livroService.buscarLivro(id), HttpStatus.OK);
    }
}
