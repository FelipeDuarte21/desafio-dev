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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_transacao")
public class TipoTransacaoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo")
	private Integer tipo;

	@Column(name = "titulo", length = 80)
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "id_natureza_transacao")
	private NaturezaTransacaoEntity naturezaTransacao;
	
	@OneToMany(mappedBy = "tipoTransacao")
	private List<TransacaoEntity> transacoes = new ArrayList<>();
	
	public TipoTransacaoEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public NaturezaTransacaoEntity getNaturezaTransacao() {
		return naturezaTransacao;
	}

	public void setNaturezaTransacao(NaturezaTransacaoEntity naturezaTransacao) {
		this.naturezaTransacao = naturezaTransacao;
	}

	public List<TransacaoEntity> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<TransacaoEntity> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipo, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoTransacaoEntity other = (TipoTransacaoEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipo, other.tipo) && Objects.equals(titulo, other.titulo);
	}
	
}
