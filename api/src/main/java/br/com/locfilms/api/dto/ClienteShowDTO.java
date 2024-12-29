package br.com.locfilms.api.dto;

import java.io.Serializable;

import br.com.locfilms.api.models.Cliente;

public class ClienteShowDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id; // puxa o id da classe model cliente
	private String nome; //puxa o nome da classe model cliente
	private String email; //puxa o email da classe model cliente
	private String telefone; //puxa o telefone da classe model cliente
	
	public ClienteShowDTO() {
		
	}
	
	public ClienteShowDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
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
