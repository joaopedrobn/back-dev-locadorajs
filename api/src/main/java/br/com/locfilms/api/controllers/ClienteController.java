package br.com.locfilms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.dto.LoginDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;
import br.com.locfilms.api.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/msg")
    public String listMsg() {
        return "Clientes!";
    }

    // Endpoint Lista Todos Clientes
    @GetMapping
    public ResponseEntity<List<ClienteShowDTO>> listar() {
        List<ClienteShowDTO> cliente = clienteService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    // Endpoint Criar Cliente
    @PostMapping
    public ResponseEntity<ClienteShowDTO> createCliente(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        ClienteShowDTO response = clienteService.createCliente(clienteCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Endpoint Lista Cliente por ID (Corrigido para evitar conflito de rota)
    @GetMapping("/id/{id}")
    public ResponseEntity<ClienteShowDTO> listaClienteUnico(@PathVariable Long id) throws ClienteNotFoundException {
        ClienteShowDTO response = clienteService.listaClienteUnico(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Endpoint Atualiza Cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteShowDTO> atualizaCliente(@PathVariable Long id, @RequestBody ClienteCreateDTO clienteCreateDTO) 
            throws ClienteNotFoundException {
        ClienteShowDTO response = clienteService.atualizaCliente(id, clienteCreateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Endpoint Deleta Cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluiCliente(@PathVariable Long id) throws ClienteNotFoundException {
        clienteService.excluiCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente " + id + " excluído com sucesso");
    }

    // Endpoint de Login (Corrigido uso de HttpStatus.OK)
    @PostMapping("/login")
    public ResponseEntity<ClienteShowDTO> login(@RequestBody LoginDTO loginDTO) throws ClienteNotFoundException {
        ClienteShowDTO response = clienteService.login(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
