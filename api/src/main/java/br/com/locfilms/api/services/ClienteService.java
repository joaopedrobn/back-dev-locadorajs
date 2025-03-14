package br.com.locfilms.api.services;

import java.util.List;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.dto.LoginDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;

public interface ClienteService {
	
	//Lista todos os clientes
	
	List<ClienteShowDTO> listar();
	
	ClienteShowDTO createCliente(ClienteCreateDTO clienteCreateDTO);

	ClienteShowDTO listaClienteUnico(Long id) throws ClienteNotFoundException;

	ClienteShowDTO atualizaCliente(Long id, ClienteCreateDTO clienteCreateDTO) throws ClienteNotFoundException;
	
	void excluiCliente(Long id) throws ClienteNotFoundException;
	
	ClienteShowDTO login (LoginDTO loginDTO) throws ClienteNotFoundException;
	
}
