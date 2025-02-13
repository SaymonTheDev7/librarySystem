package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Livro;
import com.example.sistemaBiblioteca.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping("/criarlivro")
    public ResponseEntity <Livro> criarLivro( @RequestBody Livro livro){
        return new ResponseEntity<>(livroService.criarLivro(livro), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletarlivro/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Integer id){
        livroService.deletarLivro(id);
        return new ResponseEntity<>("Livro deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/atualizarlivro/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Integer id, @RequestBody Livro livro){
        return new ResponseEntity<>(livroService.atualizarLivro(id, livro), HttpStatus.OK);
    }

    @GetMapping("/buscarlivro/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Integer id){
        return new ResponseEntity<>(livroService.buscarLivro(id), HttpStatus.OK);
    }
}
