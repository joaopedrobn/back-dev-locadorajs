package br.com.locfilms.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.locfilms.api.models.Cliente;
import br.com.locfilms.api.models.Filme;
import br.com.locfilms.api.models.Locacao;

@JsonInclude(JsonInclude.Include.NON_NULL) // Evita serializar campos nulos
public class ResponseLocacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonIgnoreProperties({"locacoes"}) // Evita loops de serialização se Cliente tiver referência para Locacao
    private Cliente cliente;

    @JsonIgnoreProperties({"locacoes"}) // Evita loops de serialização se Filme tiver referência para Locacao
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
        this.valor = locacao.getValor();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
