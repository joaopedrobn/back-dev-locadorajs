package br.com.locfilms.api.services;

import java.util.List;

import br.com.locfilms.api.dto.ClienteShowDTO;

public interface ClienteService {
	
	List<ClienteShowDTO> listar();

}
