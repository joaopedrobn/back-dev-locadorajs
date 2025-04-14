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

	private final FilmeRepository filmeRepository;
	private final MapStructFilmeMapper filmeMapper;

	@Autowired
	public FilmeServiceImpl(FilmeRepository filmeRepository, MapStructFilmeMapper filmeMapper) {
		this.filmeRepository = filmeRepository;
		this.filmeMapper = filmeMapper;
	}

	@Override
	public List<FilmeShowDTO> listar() {
		return filmeRepository.findAll()
				.stream()
				.map(filmeMapper::filmeToFilmeShowDTO)
				.collect(Collectors.toList());
	}

	@Override
	public FilmeShowDTO createFilme(FilmeCreateDTO filmeCreateDTO) {
		Filme novoFilme = filmeMapper.toModel(filmeCreateDTO);
		novoFilme.setStatus("Disponível");
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
		filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		
		Filme atualizaFilme = filmeMapper.toModel(filmeCreateDTO);
		atualizaFilme.setId(id);
		Filme response = filmeRepository.save(atualizaFilme);
		return filmeMapper.filmeToFilmeShowDTO(response);
	}

	@Override
	public void excluiFilme(Long id) throws FilmeNotFoundException {
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		filmeRepository.deleteById(id);
	}

	@Override
	public List<FilmeShowDTO> listarDisponiveis() {
		return filmeRepository.findAll()
				.stream()
				.filter(filme -> "Disponível".equals(filme.getStatus()))
				.map(filmeMapper::filmeToFilmeShowDTO)
				.collect(Collectors.toList());
	}
}
