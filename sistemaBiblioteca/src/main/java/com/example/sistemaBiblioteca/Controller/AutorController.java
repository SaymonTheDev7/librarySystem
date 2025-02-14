package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Autor;
import com.example.sistemaBiblioteca.Service.AutorService;
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
 * Controlador responsável por gerenciar operações relacionadas aos autores.
 */
@RestController
@RequestMapping("api/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    /**
     * Cria um novo autor.
     *
     * @param autor Objeto Autor contendo as informações do autor.
     * @return ResponseEntity contendo o autor criado e status 201 (Created).
     */
    @PostMapping("/criarautor")
    @Operation(summary = "Cria um novo autor", description = "Cria um novo autor")
    @Tag(name = "Autor", description = "Operações relacionadas aos autores")
    @ApiResponse(responseCode = "201", description = "Autor criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao criar autor")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Autor> criarAutor(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody
                                            @Parameter(description = "Informações do autor", required = true,
                                                    content = @Content(schema = @Schema(implementation = Autor.class),
                                                            examples = @ExampleObject(value = "{\"nome\": \"Autor 1\", \"nacionalidade\": \"Nacionalidade 1\", \"dataNascimento\": \"Data de nascimento 1\", \"biografia\": \"Biografia 1\", \"genero\": \"Gênero 1\"}"))) Autor autor) {
        return new ResponseEntity<>(autorService.criarAutor(autor), HttpStatus.CREATED);
    }

    /**
     * Deleta um autor pelo ID.
     *
     * @param id ID do autor a ser deletado.
     * @return ResponseEntity contendo a mensagem de sucesso e status 200 (OK).
     */
    @DeleteMapping("/deletarautor/{id}")
    @Operation(summary = "Deleta um autor", description = "Deleta um autor")
    @Tag(name = "Autor", description = "Operações relacionadas aos autores")
    @ApiResponse(responseCode = "200", description = "Autor deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> deletarAutor(@PathVariable @Parameter(description = "ID do autor", required = true,
            content = @Content(examples = @ExampleObject(value = "1"))) Integer id) {
        autorService.deletarAutor(id);
        return new ResponseEntity<>("Autor deletado com sucesso", HttpStatus.OK);
    }

    /**
     * Busca um autor pelo ID.
     *
     * @param id ID do autor a ser buscado.
     * @return ResponseEntity contendo o autor encontrado e status 200 (OK).
     */
    @GetMapping("/buscarautor/{id}")
    @Operation(summary = "Busca um autor", description = "Busca um autor")
    @Tag(name = "Autor", description = "Operações relacionadas aos autores")
    @ApiResponse(responseCode = "200", description = "Autor encontrado")
    @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Autor> buscarAutor(@PathVariable @Parameter(description = "ID do autor", required = true,
            content = @Content(examples = @ExampleObject(value = "1"))) Integer id) {
        return new ResponseEntity<>(autorService.buscarAutor(id), HttpStatus.OK);
    }

    /**
     * Atualiza um autor pelo ID.
     *
     * @param id    ID do autor a ser atualizado.
     * @param autor Objeto Autor contendo as novas informações.
     * @return ResponseEntity contendo o autor atualizado e status 200 (OK).
     */
    @PutMapping("/atualizarautor/{id}")
    @Operation(summary = "Atualiza um autor", description = "Atualiza um autor")
    @Tag(name = "Autor", description = "Operações relacionadas aos autores")
    @ApiResponse(responseCode = "200", description = "Autor atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable @Parameter(description = "ID do autor", required = true,
            content = @Content(examples = @ExampleObject(value = "1"))) Integer id,
                                                @RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.atualizarAutor(id, autor), HttpStatus.OK);
    }
}
