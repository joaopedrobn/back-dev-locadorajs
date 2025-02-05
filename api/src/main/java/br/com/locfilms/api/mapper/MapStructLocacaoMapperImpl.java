package br.com.locfilms.api.mapper;

import org.springframework.stereotype.Component;

import br.com.locfilms.api.dto.LocacaoCreateDTO;
import br.com.locfilms.api.dto.ResponseLocacaoDTO;
import br.com.locfilms.api.models.Locacao;

@Component

public class MapStructLocacaoMapperImpl implements MapStructLocacaoMapper{

	@Override
	public ResponseLocacaoDTO toDTO(Locacao locacao) {
		return new ResponseLocacaoDTO(locacao);
	}

	@Override
	public Locacao toModel(LocacaoCreateDTO locacaoCreateDTO) {
		return new Locacao(locacaoCreateDTO);
	}
	
	

}
