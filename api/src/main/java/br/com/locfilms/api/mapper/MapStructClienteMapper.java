package br.com.locfilms.api.mapper;

import org.mapstruct.Mapper;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.models.Cliente;

@Mapper(componentModel = "spring")

public interface MapStructClienteMapper {

	ClienteShowDTO clienteToClienteShowDTO(Cliente cliente);
	
	Cliente toModel(ClienteCreateDTO clienteCreateDTO);
	
}
