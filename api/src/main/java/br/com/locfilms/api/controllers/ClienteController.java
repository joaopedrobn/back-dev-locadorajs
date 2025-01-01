package br.com.locfilms.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
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
	
	
	//Endpoint Atualiza Cliente
	
	
	//Endpoint Deleta Cliente

}
