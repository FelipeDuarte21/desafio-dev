package br.com.luizfelipe.backend.dto;

import br.com.luizfelipe.backend.model.CartaoEntity;

public class CartaoDTO {
	
	private Long id;
	private String numero;
	
	public CartaoDTO() {
		
	}
	
	public CartaoDTO(CartaoEntity cartaoEntity) {
		this.id = cartaoEntity.getId();
		this.numero = cartaoEntity.getNumero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
