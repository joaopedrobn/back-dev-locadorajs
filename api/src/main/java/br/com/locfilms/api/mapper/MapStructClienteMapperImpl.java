package br.com.locfilms.api.mapper;

import org.springframework.stereotype.Component;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.models.Cliente;

@Component

public class MapStructClienteMapperImpl implements MapStructClienteMapper{

	@Override
	public ClienteShowDTO clienteToClienteShowDTO(Cliente cliente) {
		return new ClienteShowDTO(cliente);
	}

	@Override
	public Cliente toModel(ClienteCreateDTO clienteCreateDTO) {
		return new Cliente(clienteCreateDTO);
	}
	
	
	
}
