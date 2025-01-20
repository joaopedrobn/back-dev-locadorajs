package br.com.locfilms.api.dto;

import java.io.Serializable;

public class FilmeCreateDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String genero;
	
	public FilmeCreateDTO() {
		
	}
	
	public FilmeCreateDTO(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
