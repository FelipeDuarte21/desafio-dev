package br.com.luizfelipe.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiario")
public class BeneficiarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@OneToMany(mappedBy = "beneficiario")
	private List<TransacaoEntity> transacoes = new ArrayList<>();
	
	public BeneficiarioEntity() {
		
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

	public List<TransacaoEntity> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<TransacaoEntity> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiarioEntity other = (BeneficiarioEntity) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

}
