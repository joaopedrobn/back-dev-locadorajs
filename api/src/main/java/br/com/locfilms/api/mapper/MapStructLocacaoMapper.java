package br.com.locfilms.api.mapper;

import org.mapstruct.Mapper;

import br.com.locfilms.api.dto.LocacaoCreateDTO;
import br.com.locfilms.api.dto.ResponseLocacaoDTO;
import br.com.locfilms.api.models.Locacao;

@Mapper(componentModel = "spring")

public interface MapStructLocacaoMapper {

	ResponseLocacaoDTO toDTO(Locacao locacao);
	
	Locacao toModel(LocacaoCreateDTO locacaoCreateDTO);
	
	
	
}
