package br.com.locfilms.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locfilms.api.dto.FilmeCreateDTO;
import br.com.locfilms.api.dto.FilmeShowDTO;
import br.com.locfilms.api.exception.FilmeNotFoundException;
import br.com.locfilms.api.mapper.MapStructFilmeMapper;
import br.com.locfilms.api.models.Filme;
import br.com.locfilms.api.repositories.FilmeRepository;

@Service

public class FilmeServiceImpl implements FilmeService {

	@Override
	public List<FilmeShowDTO> listar() {	
		return this.filmeRepository.findAll()
				.stream().map(filme ->
				this.filmeMapper.filmeToFilmeShowDTO(filme))
				.collect(Collectors.toList());
	}
	
	private FilmeRepository filmeRepository;
	private MapStructFilmeMapper filmeMapper;
	
	@Autowired
	public FilmeServiceImpl(FilmeRepository filmeRepository, 
			MapStructFilmeMapper filmeMapper) {
		
		this.filmeRepository = filmeRepository;
		this.filmeMapper = filmeMapper;
		
	}

	@Override
	public FilmeShowDTO createFilme(FilmeCreateDTO filmeCreateDTO) {
		Filme novoFilme = filmeMapper.toModel(filmeCreateDTO);
		Filme response = filmeRepository.save(novoFilme);
		return filmeMapper.filmeToFilmeShowDTO(response);
	}

	@Override
	public FilmeShowDTO listaFilmeUnico(Long id) throws FilmeNotFoundException {
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));			
		return filmeMapper.filmeToFilmeShowDTO(filme);
	}

	@Override
	public FilmeShowDTO atualizaFilme(Long id, FilmeCreateDTO filmeCreateDTO) throws FilmeNotFoundException {
		Filme atualizaFilme = filmeMapper.toModel(filmeCreateDTO);
		Filme buscaFilme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		atualizaFilme.setId(id);
		Filme response = filmeRepository.save(atualizaFilme);
		return filmeMapper.filmeToFilmeShowDTO(atualizaFilme);
	}

	@Override
	public void excluiFilme(Long id) throws FilmeNotFoundException {
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		filmeRepository.deleteById(id);
	}
	
	@Override
	public List<FilmeShowDTO> listarDisponiveis() {
		return this.filmeRepository.findAll()
				.stream()
				.filter(filme -> filme.getStatus().equals("Disponível"))
				.map(filme -> this.filmeMapper.filmeToFilmeShowDTO(filme))
				.collect(Collectors.toList());
	}

	
	
}
