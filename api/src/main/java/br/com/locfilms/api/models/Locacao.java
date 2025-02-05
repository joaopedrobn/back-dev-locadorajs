package br.com.locfilms.api.models;

import br.com.locfilms.api.dto.LocacaoCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "locacao")

public class Locacao {

	@Id
	@SequenceGenerator(name ="id", sequenceName = "locacao_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locacao_id")
	private long id;

	@ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToOne(targetEntity = Filme.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "filme_id")
	private Filme filme;
	
	@Column(nullable = false, length = 80)
	private String data;
	
	@Column(nullable = false, length = 60)
	private String valor; 
	
	public Locacao () {
		
	}
	
	public Locacao(LocacaoCreateDTO locacaoCreateDTO) {
		this.cliente = locacaoCreateDTO.getCliente();
		this.filme = locacaoCreateDTO.getFilme();
		this.data = locacaoCreateDTO.getData();
		this.valor = locacaoCreateDTO.getValor();
	}

	public long getId() {
		return id;
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

	public void setId(long id) {
		this.id = id;
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
