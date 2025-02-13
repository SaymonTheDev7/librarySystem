package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Emprestimo;
import com.example.sistemaBiblioteca.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("aoi/emprestimo")
@RestController
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping("/criaremprestimo")
    public ResponseEntity<Emprestimo> criarEmprestimo(Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.criarEmprestimo(emprestimo), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletaremprestimo/{id}")
    public ResponseEntity<String> deletarEmprestimo(Integer id) {
        emprestimoService.deletarEmprestimo(id);
        return new ResponseEntity<>("Emprestimo deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Emprestimo> atualizarEmprestimo(Integer id, Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.atualizarEmprestimo(id, emprestimo), HttpStatus.OK);
    }

    @GetMapping("/buscaremprestimo/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimo(Integer id) {
        return new ResponseEntity<>(emprestimoService.buscarEmprestimo(id), HttpStatus.OK);
    }
}
