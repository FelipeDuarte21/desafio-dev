package br.com.luizfelipe.backend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transacao")
public class TransacaoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_hora")
	private LocalDateTime dataHora;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "id_loja")
	private LojaEntity loja;
	
	@ManyToOne
	@JoinColumn(name = "id_cartao")
	private CartaoEntity cartao;
	
	@ManyToOne
	@JoinColumn(name = "id_beneficiario")
	private BeneficiarioEntity beneficiario;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_transacao")
	private TipoTransacaoEntity tipoTransacao;

	public TransacaoEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LojaEntity getLoja() {
		return loja;
	}

	public void setLoja(LojaEntity loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHora, id, valor);
	}

	public CartaoEntity getCartao() {
		return cartao;
	}

	public void setCartao(CartaoEntity cartao) {
		this.cartao = cartao;
	}

	public BeneficiarioEntity getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(BeneficiarioEntity beneficiario) {
		this.beneficiario = beneficiario;
	}

	public TipoTransacaoEntity getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacaoEntity tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoEntity other = (TransacaoEntity) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(id, other.id)
				&& Objects.equals(valor, other.valor);
	}
	
}
