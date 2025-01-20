package br.com.locfilms.api.mapper;

import org.mapstruct.Mapper;

import br.com.locfilms.api.dto.FilmeCreateDTO;
import br.com.locfilms.api.dto.FilmeShowDTO;
import br.com.locfilms.api.models.Filme;

@Mapper(componentModel = "spring")

public interface MapStructFilmeMapper {

	FilmeShowDTO filmeToFilmeShowDTO(Filme filme);
	
	Filme toModel(FilmeCreateDTO filmeCreateDTO);
	
}
