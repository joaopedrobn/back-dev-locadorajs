package br.com.locfilms.api.models;

import java.io.Serializable;

import br.com.locfilms.api.dto.FilmeCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")

public class Filme implements Serializable{
	
	//Entidades
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "id", sequenceName = "filme_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, length = 160)
	private String nome;
	
	@Column(nullable = false, length = 80)
	private String genero;
	
	public Filme() {
		
	}
	
	public Filme(FilmeCreateDTO filmeCreateDTO) {
		this.nome = filmeCreateDTO.getNome();
		this.genero = filmeCreateDTO.getGenero ();
	}
	
	//Getters and Setters
	
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

	public void setGenero(String genero) {
		this.genero = genero;
	}

}