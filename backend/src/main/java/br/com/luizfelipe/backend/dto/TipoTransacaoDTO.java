package br.com.luizfelipe.backend.dto;

public class TipoTransacaoDTO {
	
	private String tipo;
	private String natureza;
	
	public TipoTransacaoDTO(String tipo, String natureza) {
		this.tipo = tipo;
		this.natureza = natureza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

}
