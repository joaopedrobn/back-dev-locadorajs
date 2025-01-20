package br.com.locfilms.api.mapper;

import org.springframework.stereotype.Component;

import br.com.locfilms.api.dto.FilmeCreateDTO;
import br.com.locfilms.api.dto.FilmeShowDTO;
import br.com.locfilms.api.models.Filme;

@Component

public class MapStructFilmeMapperImpl implements MapStructFilmeMapper{

	@Override
	public FilmeShowDTO filmeToFilmeShowDTO(Filme filme) {
		return new FilmeShowDTO(filme);
	}

	@Override
	public Filme toModel(FilmeCreateDTO filmeCreateDTO) {
		return new Filme(filmeCreateDTO);
	}
	
	
	
}
