package br.com.luizfelipe.backend.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class ArquivoUtilTest {

	@Test
	void verificaSeContentTypeEAceito() {
		
		String contentType = "text/plain";
		
		assertTrue(new ArquivoUtil().verificarContentType(contentType));
		
	}
	
	@Test
	void verificaSeContentTypeNaoEAceito() {
		
		String contentType = "text/css";
		
		assertThrows(IllegalArgumentException.class, 
				() -> new ArquivoUtil().verificarContentType(contentType));
		
	}
	
	@Test
	void verificaSeExtensaoEAceita() {
		
		String extensao = "arquivo.txt";
		
		assertTrue(new ArquivoUtil().verificarExtensao(extensao));
		
	}
	
	@Test
	void verificaSeExtensaoNaoEAceita() {
		
		String extensao = "arquivo.csv";
		
		assertThrows(IllegalArgumentException.class, 
				() -> new ArquivoUtil().verificarExtensao(extensao));
		
	}
	
	@Test
	void verificaSeLinhaEMenorQue80Caracteres() {
		
		String linha = "11111111111111111111";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarLinha(linha));
		
	}
	
	@Test
	void verificaSeLinhaEMaiorQue80Caracteres() {
		
		String linha = "111111111111111111111111111111111111111111111111111111111111111111111111111111111";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarLinha(linha));
		
	}
	
	@Test
	void verificaSeLinhaEIgualQue80Caracteres() {
		
		String linha = "11111111111111111111111111111111111111111111111111111111111111111111111111111111";
		
		assertTrue(new ArquivoUtil().verificarLinha(linha));
		
	}
	
	@Test
	void verificarSeTipoEInvalido() {
		
		String letra = "A";
		String especial = "*";
		String qtd = "12";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarTipo(letra));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarTipo(especial));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarTipo(qtd));
		
	}
	
	@Test
	void verificarSeTipoEValido() {
		
		String tipo = "1";
		
		assertTrue(new ArquivoUtil().verificarTipo(tipo));
		
	}
	
	@Test
	void verificaSeDataEInvalida() {
		
		String data1 = "YYYYMMDD";
		String data2 = "202204";
		String data3 = "20220410145700";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarData(data1));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarData(data2));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarData(data3));
		
	}
	
	@Test
	void verificaSeDataEValida() {
		
		String data = "20220410";
		
		assertTrue(new ArquivoUtil().verificarData(data));
		
	}
	
	@Test
	void verificaSeValorEInvalido() {
		
		String valor1 = "XXXXXXXXXX";
		String valor2 = "066058068489";
		String valor3 = "066058";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarValor(valor1));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarValor(valor2));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarValor(valor3));
		
	}
	
	@Test
	void verificaSeValorEValido() {
		
		String valor = "0660580684";
		
		assertTrue(new ArquivoUtil().verificarValor(valor));
		
	}
	
	@Test
	void verificarSeCpfBeneficiarioNaoEValido() {
		
		String cpf1 = "AAAAAAAAAAA";
		String cpf2 = "158";
		String cpf3 = "5686354874852";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarCpfBeneficiario(cpf1));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarCpfBeneficiario(cpf2));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarCpfBeneficiario(cpf3));
		
	}
	
	@Test
	void verificaSeCpfBeneficiarioEValido() {
		
		String cpf = "56863548748";
		
		assertTrue(new ArquivoUtil().verificarCpfBeneficiario(cpf));
		
	}
	
	@Test
	void verificaSeNumeroCartaoEInvalido() {
		
		String n1 = "AAAA****AAAA";
		String n2 = "22****22";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarNumeroCartao(n1));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarNumeroCartao(n2));
		
	}
	
	@Test
	void verificaSeNumeroCartaoEValido() {
		
		String n = "5805****5802";
		
		assertTrue(new ArquivoUtil().verificarNumeroCartao(n));
		
	}
	
	@Test
	void verificaSeHoraEInvalida() {
		
		String hora1 = "HHmmSS";
		String hora2 = "1522";
		String hora3 = "152245123";
		
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarHora(hora1));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarHora(hora2));
		assertThrows(IllegalArgumentException.class, () -> new ArquivoUtil().verificarHora(hora3));
		
	}
	
	@Test
	void verificaSeHoraValida() {
		
		String hora = "152245";
		
		assertTrue(new ArquivoUtil().verificarHora(hora));
		
	}
	
	
}
