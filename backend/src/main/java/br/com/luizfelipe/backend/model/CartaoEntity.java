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
@Table(name = "cartao")
public class CartaoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero", length = 12)
	private String numero;
	
	@OneToMany(mappedBy = "cartao")
	private List<TransacaoEntity> transacoes = new ArrayList<>();
	
	public CartaoEntity() {
		
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

	public List<TransacaoEntity> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<TransacaoEntity> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoEntity other = (CartaoEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}

}
