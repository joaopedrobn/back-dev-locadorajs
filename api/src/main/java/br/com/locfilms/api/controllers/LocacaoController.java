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
import br.com.locfilms.api.dto.LocacaoCreateDTO;
import br.com.locfilms.api.dto.ResponseLocacaoDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;
import br.com.locfilms.api.exception.FilmeNotFoundException;
import br.com.locfilms.api.services.LocacaoService;

@RestController
@RequestMapping("/locacoes")

public class LocacaoController {
	
	private LocacaoService locacaoService;
	
	@Autowired
	public LocacaoController(LocacaoService locacaoService) {
		this.locacaoService =locacaoService;
	}
	
    @GetMapping("/msg")
    public String listMsg() {
        return "Locações!";
    }

	// Endpoint Busca Locacao
	@GetMapping
	public ResponseEntity<List<ResponseLocacaoDTO>> listar() {
		List<ResponseLocacaoDTO> locacao = locacaoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(locacao);
	}
	
    // Endpoint Criar Locacao
	@PostMapping
	public ResponseEntity<ResponseLocacaoDTO> createLocacao(@RequestBody LocacaoCreateDTO locacaoCreateDTO) throws ClienteNotFoundException, FilmeNotFoundException {
		ResponseLocacaoDTO locacao = locacaoService.createLocacao(locacaoCreateDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(locacao);
	}
	
//	// Endpoint Lista Filme por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ResponseLocacaoDTO> listaLocacaoUnico(@PathVariable Long id) throws LocacaoNotFoundException {
//        LocacaoShowDTO response = locacaoService.listaLocacaoUnico(id);
//        return ResponseEntity.status(HttpStatus.OK).body(locacao);
//    }
//
//    // Endpoint Atualiza Filme
//    @PutMapping("/{id}")
//    public ResponseEntity<FilmeShowDTO> atualizaFilme(@PathVariable Long id, @RequestBody FilmeCreateDTO filmeCreateDTO) throws FilmeNotFoundException {
//        FilmeShowDTO response = filmeService.atualizaFilme(id, filmeCreateDTO);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//    // Endpoint Deleta Filme
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> excluiFilme(@PathVariable Long id) throws FilmeNotFoundException {
//        filmeService.excluiFilme(id);
//        return ResponseEntity.status(HttpStatus.OK).body("Filme " + id + " excluído com sucesso");
	
}
