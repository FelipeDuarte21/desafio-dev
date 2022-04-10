package br.com.luizfelipe.backend.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class SeparadorDataHoraTest {

	@Test
	void verificaSeStringDataHoraEMenorQue14Caracteres(){
		
		String dataHora = "20220410";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora));
		
	}
	
	@Test
	void verificaSeStringDataHoraEMaiorQue14Caracteres(){
		
		String dataHora = "202204101349581056";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora));
		
	}
	
	@Test
	void verificaSeStringDataHoraEstaComMesInvalido() {
		
		String dataHora = "20221304134958";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora).getDataHora());
		
	}
	
	@Test
	void verificaSeStringDataHoraEstaComDiaInvalido() {
		
		String dataHora = "20220231134958";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora).getDataHora());
		
	}
	
	@Test
	void verificaSeStringDataHoraEstaComHoraInvalido() {
		
		String dataHora = "20220410264958";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora).getDataHora());
		
	}
	
	@Test
	void verificaSeStringDataHoraEstaComMinutosInvalido() {
		
		String dataHora = "20220410137058";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora).getDataHora());
		
	}
	
	@Test
	void verificaSeStringDataHoraEstaComSegundosInvalido() {
		
		String dataHora = "20220410135870";
		
		assertThrows(IllegalArgumentException.class, () -> new SeparadorDataHora(dataHora).getDataHora());
		
	}

}
