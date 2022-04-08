package br.com.luizfelipe.backend.dto;

import java.math.BigDecimal;

import br.com.luizfelipe.backend.model.ContaEntity;

public class ContaDTO {
		
	private Long id;
	private BigDecimal saldo;
	
	public ContaDTO() {
		
	}
	
	public ContaDTO(ContaEntity conta) {
		this.id = conta.getId();
		this.saldo = conta.getSaldo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
}
