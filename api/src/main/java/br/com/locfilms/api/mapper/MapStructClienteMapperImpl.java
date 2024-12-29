package br.com.locfilms.api.mapper;

import org.springframework.stereotype.Component;

import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.models.Cliente;

@Component

public class MapStructClienteMapperImpl implements MapStructClienteMapper{

	@Override
	public ClienteShowDTO clienteToClienteShowDTO(Cliente cliente) {
		return new ClienteShowDTO(cliente);
	}
	
	
	
}
