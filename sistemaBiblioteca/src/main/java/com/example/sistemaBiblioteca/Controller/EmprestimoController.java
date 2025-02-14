package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Emprestimo;
import com.example.sistemaBiblioteca.Service.EmprestimoService;
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
 * Controlador responsável por gerenciar operações relacionadas aos empréstimos.
 */
@RestController
@RequestMapping("api/emprestimo")
@Tag(name = "Emprestimo", description = "Operações relacionadas aos empréstimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    /**
     * Cria um novo empréstimo.
     *
     * @param emprestimo Objeto Emprestimo contendo as informações do empréstimo.
     * @return ResponseEntity contendo o empréstimo criado e status 201 (Created).
     */
    @PostMapping("/criaremprestimo")
    @Operation(summary = "Cria um novo empréstimo", description = "Cria um novo empréstimo.")
    @ApiResponse(responseCode = "201", description = "Empréstimo criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao criar empréstimo")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Emprestimo> criarEmprestimo(
            @RequestBody @Parameter(description = "Informações do empréstimo", required = true,
                    content = @Content(schema = @Schema(implementation = Emprestimo.class),
                            examples = @ExampleObject(value = "{\"dataEmprestimo\": \"2025-02-01\", \"dataDevolucao\": \"2025-02-15\"}")))
            Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.criarEmprestimo(emprestimo), HttpStatus.CREATED);
    }

    /**
     * Deleta um empréstimo pelo ID.
     *
     * @param id ID do empréstimo a ser deletado.
     * @return ResponseEntity contendo a mensagem de sucesso e status 200 (OK).
     */
    @DeleteMapping("/deletaremprestimo/{id}")
    @Operation(summary = "Deleta um empréstimo", description = "Deleta um empréstimo pelo ID.")
    @ApiResponse(responseCode = "200", description = "Empréstimo deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> deletarEmprestimo(
            @PathVariable @Parameter(description = "ID do empréstimo", required = true,
                    content = @Content(examples = @ExampleObject(value = "1")))
            Integer id) {
        emprestimoService.deletarEmprestimo(id);
        return new ResponseEntity<>("Empréstimo deletado com sucesso", HttpStatus.OK);
    }

    /**
     * Atualiza um empréstimo pelo ID.
     *
     * @param id ID do empréstimo a ser atualizado.
     * @param emprestimo Objeto Emprestimo contendo as novas informações.
     * @return ResponseEntity contendo o empréstimo atualizado e status 200 (OK).
     */
    @PutMapping("/atualizaremprestimo/{id}")
    @Operation(summary = "Atualiza um empréstimo", description = "Atualiza um empréstimo pelo ID.")
    @ApiResponse(responseCode = "200", description = "Empréstimo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(
            @PathVariable @Parameter(description = "ID do empréstimo", required = true,
                    content = @Content(examples = @ExampleObject(value = "1")))
            Integer id,
            @RequestBody @Parameter(description = "Novas informações do empréstimo", required = true,
                    content = @Content(schema = @Schema(implementation = Emprestimo.class)))
            Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.atualizarEmprestimo(id, emprestimo), HttpStatus.OK);
    }

    /**
     * Busca um empréstimo pelo ID.
     *
     * @param id ID do empréstimo a ser buscado.
     * @return ResponseEntity contendo o empréstimo encontrado e status 200 (OK).
     */
    @GetMapping("/buscaremprestimo/{id}")
    @Operation(summary = "Busca um empréstimo", description = "Busca um empréstimo pelo ID.")
    @ApiResponse(responseCode = "200", description = "Empréstimo encontrado")
    @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Emprestimo> buscarEmprestimo(
            @PathVariable @Parameter(description = "ID do empréstimo", required = true,
                    content = @Content(examples = @ExampleObject(value = "1")))
            Integer id) {
        return new ResponseEntity<>(emprestimoService.buscarEmprestimo(id), HttpStatus.OK);
    }
}
