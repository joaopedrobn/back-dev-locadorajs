package br.com.locfilms.api.dto;

import java.io.Serializable;

import br.com.locfilms.api.models.Cliente;
import br.com.locfilms.api.models.Filme;

public class LocacaoCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private Filme filme;
	private String data;
	private String valor;
	
	public LocacaoCreateDTO() {
		
	}
	
	public LocacaoCreateDTO(String data, String valor) {
		this.data = data;
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Filme getFilme() {
		return filme;
	}

	public String getData() {
		return data;
	}

	public String getValor() {
		return valor;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
