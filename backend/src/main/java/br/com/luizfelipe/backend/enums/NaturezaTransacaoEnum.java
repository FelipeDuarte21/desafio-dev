package br.com.luizfelipe.backend.enums;

public enum NaturezaTransacaoEnum {
	
	ENTRADA("+","Entrada"),
	SAIDA("-","Saída");
	
	private String sinal;
	private String natureza;
	
	private NaturezaTransacaoEnum(String sinal, String natureza) {
		this.sinal = sinal;
		this.natureza = natureza;
	}

	public String getSinal() {
		return sinal;
	}

	public void setSinal(String sinal) {
		this.sinal = sinal;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

}
