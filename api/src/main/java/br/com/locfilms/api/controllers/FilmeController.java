package br.com.locfilms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locfilms.api.dto.FilmeCreateDTO;
import br.com.locfilms.api.dto.FilmeShowDTO;
import br.com.locfilms.api.exception.FilmeNotFoundException;
import br.com.locfilms.api.services.FilmeService;

// Anotations

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private FilmeService filmeService;

    @Autowired
    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping("/msg")
    public String listMsg() {
        return "Filmes!";
    }

    // Endpoint Lista Todos Filmes
    @GetMapping
    public ResponseEntity<List<FilmeShowDTO>> listar() {
        List<FilmeShowDTO> filmes = filmeService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
    }

    // Endpoint Criar Filme
    @PostMapping
    public ResponseEntity<FilmeShowDTO> createFilme(@RequestBody FilmeCreateDTO filmeCreateDTO) {
        FilmeShowDTO response = filmeService.createFilme(filmeCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Endpoint Lista Filme por ID
    @GetMapping("/{id}")
    public ResponseEntity<FilmeShowDTO> listaFilmeUnico(@PathVariable Long id) throws FilmeNotFoundException {
        FilmeShowDTO response = filmeService.listaFilmeUnico(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Endpoint Atualiza Filme
    @PutMapping("/{id}")
    public ResponseEntity<FilmeShowDTO> atualizaFilme(@PathVariable Long id, @RequestBody FilmeCreateDTO filmeCreateDTO) throws FilmeNotFoundException {
        FilmeShowDTO response = filmeService.atualizaFilme(id, filmeCreateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Endpoint Deleta Filme
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluiFilme(@PathVariable Long id) throws FilmeNotFoundException {
        filmeService.excluiFilme(id);
        return ResponseEntity.status(HttpStatus.OK).body("Filme " + id + " excluído com sucesso");
    }
    
    // Endpoint Lista Filmes Disponiveis
    @GetMapping("/disponiveis")
    public ResponseEntity<List<FilmeShowDTO>> listarDisponiveis() {
        List<FilmeShowDTO> filmes = filmeService.listarDisponiveis();
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
    }
}
