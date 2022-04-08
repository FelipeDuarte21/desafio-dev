package br.com.luizfelipe.backend.dto;

import br.com.luizfelipe.backend.model.BeneficiarioEntity;

public class BeneficiarioDTO {
	
	private Long id;
	private String cpf;
	
	public BeneficiarioDTO() {
		
	}
	
	public BeneficiarioDTO(BeneficiarioEntity beneficiarioEntity) {
		this.id = beneficiarioEntity.getId();
		this.cpf = beneficiarioEntity.getCpf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
