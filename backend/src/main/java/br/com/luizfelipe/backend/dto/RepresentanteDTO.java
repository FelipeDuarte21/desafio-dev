package br.com.luizfelipe.backend.dto;

import br.com.luizfelipe.backend.model.RepresentanteEntity;

public class RepresentanteDTO {
	
	private Long id;
	private String nome;
	
	public RepresentanteDTO() {
		
	}
	
	public RepresentanteDTO(RepresentanteEntity representanteEntity) {
		this.id = representanteEntity.getId();
		this.nome = representanteEntity.getNome();
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

}
