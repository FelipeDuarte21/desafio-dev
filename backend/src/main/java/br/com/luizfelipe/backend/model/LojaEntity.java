package br.com.luizfelipe.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loja")
public class LojaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 19)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_representante")
	private RepresentanteEntity representante;
	
	@OneToMany(mappedBy = "loja")
	private List<TransacaoEntity> transacoes = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta")
	private ContaEntity conta;
	
	public LojaEntity() {
		
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

	public RepresentanteEntity getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteEntity representante) {
		this.representante = representante;
	}

	public List<TransacaoEntity> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<TransacaoEntity> transacoes) {
		this.transacoes = transacoes;
	}

	public ContaEntity getConta() {
		return conta;
	}

	public void setConta(ContaEntity conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LojaEntity other = (LojaEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
