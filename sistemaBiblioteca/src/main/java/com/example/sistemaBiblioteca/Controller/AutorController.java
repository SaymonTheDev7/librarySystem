package com.example.sistemaBiblioteca.Controller;

import com.example.sistemaBiblioteca.Model.Autor;
import com.example.sistemaBiblioteca.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    @PostMapping("/criarautor")
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.criarAutor(autor), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deletarAutor(@PathVariable Integer id) {
        autorService.deletarAutor(id);
        return new ResponseEntity<>("Autor deletado com sucesso", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Autor> buscarAutor(@PathVariable Integer id) {
        return new ResponseEntity<>(autorService.buscarAutor(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.atualizarAutor(id, autor), HttpStatus.OK);
    }
}
