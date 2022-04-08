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
@Table(name = "representante")
public class RepresentanteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 14)
	private String nome;
	
	@OneToMany(mappedBy = "representante")
	private List<LojaEntity> lojas = new ArrayList<>();
	
	public RepresentanteEntity() {
		
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

	public List<LojaEntity> getLojas() {
		return lojas;
	}

	public void setLojas(List<LojaEntity> lojas) {
		this.lojas = lojas;
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
		RepresentanteEntity other = (RepresentanteEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
}
