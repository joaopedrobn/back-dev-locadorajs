package br.com.locfilms.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import br.com.locfilms.api.dto.ClienteShowDTO;
import br.com.locfilms.api.dto.LoginDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;
import br.com.locfilms.api.mapper.MapStructClienteMapper;
import br.com.locfilms.api.models.Cliente;
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

	@Override
	public ClienteShowDTO createCliente(ClienteCreateDTO clienteCreateDTO) {
		Cliente novoCliente = clienteMapper.toModel(clienteCreateDTO);
		Cliente response = clienteRepository.save(novoCliente);
		return clienteMapper.clienteToClienteShowDTO(response);
	}

	@Override
	public ClienteShowDTO listaClienteUnico(Long id) throws ClienteNotFoundException {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));			
		return clienteMapper.clienteToClienteShowDTO(cliente);
	}

	@Override
	public ClienteShowDTO atualizaCliente(Long id, ClienteCreateDTO clienteCreateDTO) throws ClienteNotFoundException {
		Cliente atualizaCliente = clienteMapper.toModel(clienteCreateDTO);
		Cliente buscaCliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		atualizaCliente.setId(id);
		Cliente response = clienteRepository.save(atualizaCliente);
		return clienteMapper.clienteToClienteShowDTO(atualizaCliente);
	}

	@Override
	public void excluiCliente(Long id) throws ClienteNotFoundException {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteShowDTO login(LoginDTO loginDTO) throws ClienteNotFoundException {
		Long id = clienteRepository.findbyLogin(loginDTO.getEmail(), loginDTO.getTelefone());
        Cliente buscaCliente = clienteRepository.findById(id)
        		.orElseThrow(() -> new ClienteNotFoundException(id));
        return clienteMapper.clienteToClienteShowDTO(buscaCliente);
	}

	
	
}
