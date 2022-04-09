package br.com.luizfelipe.backend.utils;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;

public class SeparadorDataHora {

	private Integer ano;
	private Integer mes;
	private Integer dia;
	private Integer hora;
	private Integer minutos;
	private Integer segundos;
	
	public SeparadorDataHora(String horaCompleta) {
		if(horaCompleta.length() != 14)
			throw new IllegalArgumentException("Erro! esperava uma string com data e hora com 14 caracteres");
		
		this.ano = Integer.parseInt(horaCompleta.substring(0, 4));
		try {
			this.mes = Month.of(Integer.parseInt(horaCompleta.substring(4,6))).getValue();
		}catch(DateTimeException ex) {
			throw new IllegalArgumentException("Erro! mês inválido!");
		}
		this.dia = Integer.parseInt(horaCompleta.substring(6,8));
		this.hora = Integer.parseInt(horaCompleta.substring(8,10));
		this.minutos = Integer.parseInt(horaCompleta.substring(10, 12));
		this.segundos = Integer.parseInt(horaCompleta.substring(12, 14));
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public Integer getSegundos() {
		return segundos;
	}

	public void setSegundos(Integer segundos) {
		this.segundos = segundos;
	}
	
	public LocalDateTime getDataHora() {
		return LocalDateTime.of(this.ano, this.mes, this.dia, this.hora, this.minutos,this.segundos);
	}
	
}
