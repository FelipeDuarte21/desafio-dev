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
@Table(name = "natureza_transacao")
public class NaturezaTransacaoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", length = 30)
	private String titulo;
	
	@Column(name = "sinal", length = 1)
	private Character sinal;
	
	@OneToMany(mappedBy = "naturezaTransacao")
	private List<TipoTransacaoEntity> tiposTransacoes = new ArrayList<>();
	
	public NaturezaTransacaoEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Character getSinal() {
		return sinal;
	}

	public void setSinal(Character sinal) {
		this.sinal = sinal;
	}

	public List<TipoTransacaoEntity> getTiposTransacoes() {
		return tiposTransacoes;
	}

	public void setTiposTransacoes(List<TipoTransacaoEntity> tiposTransacoes) {
		this.tiposTransacoes = tiposTransacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sinal, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NaturezaTransacaoEntity other = (NaturezaTransacaoEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(sinal, other.sinal)
				&& Objects.equals(titulo, other.titulo);
	}
	
}
