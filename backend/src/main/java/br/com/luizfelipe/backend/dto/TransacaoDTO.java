package br.com.luizfelipe.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.luizfelipe.backend.enums.TipoTransacaoEnum;
import br.com.luizfelipe.backend.model.TransacaoEntity;

public class TransacaoDTO {
	
	private Long id;
	private LocalDateTime dataHora;
	private BigDecimal valor;
	private TipoTransacaoDTO tipoTransacao;
	private BeneficiarioDTO beneficiario;
	private CartaoDTO cartao;
	
	public TransacaoDTO() {
		
	}
	
	public TransacaoDTO(TransacaoEntity transacaoEntity) {
		this.id = transacaoEntity.getId();
		this.dataHora = transacaoEntity.getDataHora();
		this.valor = transacaoEntity.getValor();
		this.tipoTransacao = new TipoTransacaoDTO(
				TipoTransacaoEnum.toEnum(transacaoEntity.getTipoOperacao()).getDescricao(),
				TipoTransacaoEnum.toEnum(transacaoEntity.getTipoOperacao()).getNatureza().getNatureza());
		this.beneficiario = new BeneficiarioDTO(transacaoEntity.getBeneficiario());
		this.cartao = new CartaoDTO(transacaoEntity.getCartao());
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

	public TipoTransacaoDTO getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacaoDTO tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public BeneficiarioDTO getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(BeneficiarioDTO beneficiario) {
		this.beneficiario = beneficiario;
	}

	public CartaoDTO getCartao() {
		return cartao;
	}

	public void setCartao(CartaoDTO cartao) {
		this.cartao = cartao;
	}

}
