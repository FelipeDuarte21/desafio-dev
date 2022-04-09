package br.com.luizfelipe.backend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class ContaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "saldo")
	private BigDecimal saldo;
	
	@OneToOne(mappedBy = "conta")
	private LojaEntity loja;
	
	public ContaEntity() {
		this.saldo = new BigDecimal("0");
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

	public LojaEntity getLoja() {
		return loja;
	}

	public void setLoja(LojaEntity loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaEntity other = (ContaEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(saldo, other.saldo);
	}

}
