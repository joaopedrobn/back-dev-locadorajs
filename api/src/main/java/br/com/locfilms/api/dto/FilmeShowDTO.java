package br.com.locfilms.api.dto;

import java.io.Serializable;

import br.com.locfilms.api.models.Filme;

public class FilmeShowDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id; // puxa o id da classe model filme
	private String nome; //puxa o nome da classe model filme
	private String genero; //puxa o genero da classe model filme
	private String status; //
	
	public FilmeShowDTO() {
		
	}
	
	public FilmeShowDTO(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.genero = filme.getGenero();
		this.status = filme.getStatus();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void getGenero(String genero) {
		this.genero = genero;
	}

	
}
