package br.com.luizfelipe.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.luizfelipe.backend.model.LojaEntity;

public class LojaDTO {
	
	private Long id;
	private String nome;
	private RepresentanteDTO representante;
	private ContaDTO conta;
	private List<TransacaoDTO> transacoes = new ArrayList<>();
	
	public LojaDTO() {
		
	}
	
	public LojaDTO(LojaEntity lojaEntity) {
		this.id = lojaEntity.getId();
		this.nome = lojaEntity.getNome();
		this.representante = new RepresentanteDTO(lojaEntity.getRepresentante());
		this.conta = new ContaDTO(lojaEntity.getConta());
		this.transacoes = lojaEntity.getTransacoes().stream().map(TransacaoDTO::new).collect(Collectors.toList());
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

	public RepresentanteDTO getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteDTO representante) {
		this.representante = representante;
	}

	public ContaDTO getConta() {
		return conta;
	}

	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}

	public List<TransacaoDTO> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<TransacaoDTO> transacoes) {
		this.transacoes = transacoes;
	}
	
}
