package br.com.luizfelipe.backend.enums;

public enum TipoTransacaoEnum {
	
	DEBITO(1, "Débito", NaturezaTransacaoEnum.ENTRADA),
	SAIDA(2, "Saída", NaturezaTransacaoEnum.SAIDA),
	FINANCIAMENTO(3, "Financiamento", NaturezaTransacaoEnum.SAIDA),
	CREDITO(4, "Crédito", NaturezaTransacaoEnum.ENTRADA),
	RECEBIMENTO_EMPRESTIMO(5, "Recebimento de Empréstimo", NaturezaTransacaoEnum.ENTRADA),
	VENDAS(6, "Vendas", NaturezaTransacaoEnum.ENTRADA),
	RECEBIMENTO_TED(7, "Recebimento via TED", NaturezaTransacaoEnum.ENTRADA),
	RECEBIMENTO_DOC(8, "Recebimento via DOC", NaturezaTransacaoEnum.ENTRADA),
	ALUGUEL(9, "Aluguel", NaturezaTransacaoEnum.SAIDA);
	
	private Integer valor;
	private String descricao;
	private NaturezaTransacaoEnum natureza;
	
	private TipoTransacaoEnum(Integer valor, String descricao, NaturezaTransacaoEnum natureza) {
		this.valor = valor;
		this.descricao = descricao;
		this.natureza = natureza;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public NaturezaTransacaoEnum getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaTransacaoEnum natureza) {
		this.natureza = natureza;
	}
	
	public static TipoTransacaoEnum toEnum(Integer valor) {
		
		if(valor == null) {
			return null;
		}
		
		for(TipoTransacaoEnum x: TipoTransacaoEnum.values()) {
			if(valor.equals(x.getValor())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de Transação Inválido!");
		
	}

}
