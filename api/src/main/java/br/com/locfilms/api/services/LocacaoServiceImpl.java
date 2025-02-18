package br.com.locfilms.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locfilms.api.dto.LocacaoCreateDTO;
import br.com.locfilms.api.dto.ResponseLocacaoDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;
import br.com.locfilms.api.exception.FilmeNotFoundException;
import br.com.locfilms.api.mapper.MapStructLocacaoMapper;
import br.com.locfilms.api.models.Cliente;
import br.com.locfilms.api.models.Filme;
import br.com.locfilms.api.models.Locacao;
import br.com.locfilms.api.repositories.ClienteRepository;
import br.com.locfilms.api.repositories.FilmeRepository;
import br.com.locfilms.api.repositories.LocacaoRepository;

@Service
public class LocacaoServiceImpl implements LocacaoService{
	
	private LocacaoRepository locacaoRepository;
	private ClienteRepository clienteRepository;
	private FilmeRepository filmeRepository;
	private MapStructLocacaoMapper locacaoMapper;
	
	@Autowired
	public LocacaoServiceImpl(LocacaoRepository locacaoRepository, ClienteRepository clienteRepository, FilmeRepository filmeRepository, MapStructLocacaoMapper locacaoMapper) {
		this.locacaoRepository = locacaoRepository;
		this.clienteRepository = clienteRepository;	
		this.filmeRepository = filmeRepository;
		this.locacaoMapper = locacaoMapper;
	}

	@Override
	public List<ResponseLocacaoDTO> listar() {
		return this.locacaoRepository.findAll()
				.stream().map(locacao -> this.locacaoMapper.toDTO(locacao))
				.collect(Collectors.toList());
	}

	@Override
	public ResponseLocacaoDTO createLocacao(LocacaoCreateDTO locacaoCreateDTO)
			throws FilmeNotFoundException, ClienteNotFoundException {
		//Busca ID do Cliente que vem no Request
		Long cliente_id = locacaoCreateDTO.getCliente().getId();
		//Busca ID do Filme que vem no Request
		Long filme_id = locacaoCreateDTO.getFilme().getId();
		//Busca Cliente por ID
		Cliente cliente = clienteRepository.findById(cliente_id)
				.orElseThrow(() -> new ClienteNotFoundException(cliente_id));
		//Busca Filme por ID
		Filme filme = filmeRepository.findById(filme_id)
				.orElseThrow(() -> new FilmeNotFoundException(filme_id));
		//Salvando as informações
		Locacao locacao = locacaoMapper.toModel(locacaoCreateDTO);
		locacao.setCliente(cliente);
		locacao.setFilme(filme);
	    Locacao response = locacaoRepository.save(locacao);
	    return locacaoMapper.toDTO(response);
	    
	}
	
	

}
