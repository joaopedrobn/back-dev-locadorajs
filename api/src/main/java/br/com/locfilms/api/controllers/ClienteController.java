package br.com.locfilms.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;
import br.com.locfilms.api.services.ClienteService;

//Anotations

@SuppressWarnings("unused")
@RestController
@RequestMapping("/clientes")

public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/msg")
	public String listMsg() {
		return "Hello World";
	}
	
	//Endpoint Lista Todos Clientes
	
	@GetMapping
	public ResponseEntity<List<ClienteShowDTO>> listar() {
		List<ClienteShowDTO> cliente = clienteService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
				
	}
	
	//Endpoint Criar Cliente
	
	@PostMapping
	public ResponseEntity<ClienteShowDTO> createCliente(@RequestBody ClienteCreateDTO clienteCreateDTO){
		ClienteShowDTO response = clienteService.createCliente(clienteCreateDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//Endpoint Lista Cliente por ID
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteShowDTO> listaClienteUnico(@PathVariable Long id) throws ClienteNotFoundException {
		ClienteShowDTO response = clienteService.listaClienteUnico(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//Endpoint Atualiza Cliente
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteShowDTO> atualizaCliente(@PathVariable Long id, @RequestBody ClienteCreateDTO clienteCreateDTO) throws ClienteNotFoundException {
		ClienteShowDTO response = clienteService.atualizaCliente(id, clienteCreateDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	//Endpoint Deleta Cliente

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluiCliente(@PathVariable Long id) throws ClienteNotFoundException {
	    clienteService.excluiCliente(id);
	    return ResponseEntity.status(HttpStatus.OK).body("Cliente " + id + " excluido com sucesso ");
	}
	
}
