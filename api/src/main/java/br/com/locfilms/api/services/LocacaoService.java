package br.com.locfilms.api.services;

import java.util.List;

import br.com.locfilms.api.dto.LocacaoCreateDTO;
import br.com.locfilms.api.dto.ResponseLocacaoDTO;
import br.com.locfilms.api.exception.ClienteNotFoundException;
import br.com.locfilms.api.exception.FilmeNotFoundException;

public interface LocacaoService {

	List<ResponseLocacaoDTO> listar();

	ResponseLocacaoDTO createLocacao(LocacaoCreateDTO locacaoCreateDTO) throws FilmeNotFoundException, ClienteNotFoundException;
	
}
