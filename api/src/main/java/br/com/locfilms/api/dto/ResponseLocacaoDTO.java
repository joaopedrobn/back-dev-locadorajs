package br.com.locfilms.api.dto;

import java.io.Serializable;

import br.com.locfilms.api.models.Cliente;
import br.com.locfilms.api.models.Filme;
import br.com.locfilms.api.models.Locacao;

public class ResponseLocacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Cliente cliente;
	private Filme filme;
	private String data;
	private String valor;

	public ResponseLocacaoDTO() {
		
	}
	
	
	public ResponseLocacaoDTO(Long id, Cliente cliente, Filme filme, String data, String valor) {
		this.id = id;
		this.cliente = cliente;
		this.filme = filme;
		this.data = data;
		this.valor = valor;
	
    }
	
	public ResponseLocacaoDTO(Locacao locacao) {
		this.id = locacao.getId();
		this.cliente = locacao.getCliente();
		this.filme = locacao.getFilme();
		this.data = locacao.getData();
		this.filme = locacao.getFilme();
	
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
