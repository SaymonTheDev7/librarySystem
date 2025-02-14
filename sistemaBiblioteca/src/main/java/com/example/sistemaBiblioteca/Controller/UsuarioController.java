package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Usuario;
import com.example.sistemaBiblioteca.Service.UsuarioService;
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
 * Controlador responsável por gerenciar operações relacionadas a usuários no sistema da biblioteca.
 */
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    /**
     * Cria um novo usuário.
     *
     * @param usuario Objeto contendo as informações do usuário.
     * @return ResponseEntity contendo o usuário criado e o status HTTP 201 (Created).
     */
    @PostMapping("/criarusuario")
    @Operation(summary = "Cria um novo usuário", description = "Cria um novo usuário")
    @Tag(name = "Usuario", description = "Operações relacionadas aos usuários")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao criar usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Usuario> criarUsuario(
            @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody
            @Parameter(description = "Informações do usuário", required = true,
                    content = @Content(schema = @Schema(implementation = Usuario.class),
                            examples = @ExampleObject(value = "{\"nome\": \"Usuario 1\", \"email\": \"Email 1\", \"senha\": \"Senha 1\"}"))) Usuario usuario) {
        return new ResponseEntity<>(usuarioService.criarUsuario(usuario), HttpStatus.CREATED);
    }

    /**
     * Deleta um usuário pelo ID.
     *
     * @param id Identificador do usuário a ser deletado.
     * @return ResponseEntity contendo a mensagem de sucesso e o status HTTP 200 (OK).
     */
    @DeleteMapping("/deletarusuario/{id}")
    @Operation(summary = "Deleta um usuário", description = "Deleta um usuário")
    @Tag(name = "Usuario", description = "Operações relacionadas aos usuários")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> deletarUsuario(
            @PathVariable
            @Parameter(description = "ID do usuário", required = true,
                    content = @Content(examples = @ExampleObject(value = "1"))) Integer id) {
        usuarioService.deletarUsuario(id);
        return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.OK);
    }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id Identificador do usuário a ser buscado.
     * @return ResponseEntity contendo o usuário encontrado e o status HTTP 200 (OK).
     */
    @GetMapping("/buscarusuario/{id}")
    @Operation(summary = "Busca um usuário", description = "Busca um usuário")
    @Tag(name = "Usuario", description = "Operações relacionadas aos usuários")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Usuario> buscarUsuario(
            @PathVariable
            @Parameter(description = "ID do usuário", required = true,
                    content = @Content(examples = @ExampleObject(value = "1"))) Integer id) {
        return new ResponseEntity<>(usuarioService.buscarUsuario(id), HttpStatus.OK);
    }

    /**
     * Atualiza um usuário pelo ID.
     *
     * @param id Identificador do usuário a ser atualizado.
     * @param usuario Objeto contendo as novas informações do usuário.
     * @return ResponseEntity contendo o usuário atualizado e o status HTTP 200 (OK).
     */
    @PutMapping("/atualizarusuario/{id}")
    @Operation(summary = "Atualiza um usuário", description = "Atualiza um usuário")
    @Tag(name = "Usuario", description = "Operações relacionadas aos usuários")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable
            @Parameter(description = "ID do usuário", required = true,
                    content = @Content(examples = @ExampleObject(value = "1"))) Integer id,
            @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.atualizarUsuario(id, usuario), HttpStatus.OK);
    }
}
