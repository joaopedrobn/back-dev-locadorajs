package br.com.locfilms.api.models;

import java.io.Serializable;

import br.com.locfilms.api.dto.ClienteCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//Anotations

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable{
	
	//Entidades
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "id", sequenceName = "cliente_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, length = 160)
	private String nome;
	
	@Column(nullable = false, length = 80)
	private String email;
	
	@Column(nullable = true, length = 60)
	private String telefone;
	
	public Cliente() {
		
	}
	
	public Cliente(ClienteCreateDTO clienteCreateDTO) {
		this.nome = clienteCreateDTO.getNome();
		this.email = clienteCreateDTO.getEmail();			
		this.telefone = clienteCreateDTO.getTelefone();
	}
	
    // Getters and Setters

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
