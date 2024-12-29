package br.com.locfilms.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.mapper.MapStructClienteMapper;
import br.com.locfilms.api.repositories.ClienteRepository;

@Service

public class ClienteServiceImpl implements ClienteService {

	@Override
	public List<ClienteShowDTO> listar() {	
		return this.clienteRepository.findAll()
				.stream().map(cliente ->
				this.clienteMapper.clienteToClienteShowDTO(cliente))
				.collect(Collectors.toList());
	}
	
	private ClienteRepository clienteRepository;
	private MapStructClienteMapper clienteMapper;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository, 
			MapStructClienteMapper clienteMapper) {
		
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
		
	}

	
	
}
