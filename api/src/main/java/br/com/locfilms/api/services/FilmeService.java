package br.com.locfilms.api.services;

import java.util.List;

import br.com.locfilms.api.dto.FilmeCreateDTO;
import br.com.locfilms.api.dto.FilmeShowDTO;
import br.com.locfilms.api.exception.FilmeNotFoundException;

public interface FilmeService {
	
	// Lista todos os filmes
	List<FilmeShowDTO> listar();
	
	// Lista filmes disponíveis
	List<FilmeShowDTO> listarDisponiveis();
	
	FilmeShowDTO createFilme(FilmeCreateDTO filmeCreateDTO);

	FilmeShowDTO listaFilmeUnico(Long id) throws FilmeNotFoundException;

	FilmeShowDTO atualizaFilme(Long id, FilmeCreateDTO filmeCreateDTO) throws FilmeNotFoundException;
	
	void excluiFilme(Long id) throws FilmeNotFoundException;
}
