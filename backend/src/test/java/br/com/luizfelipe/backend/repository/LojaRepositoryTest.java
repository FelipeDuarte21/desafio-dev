package br.com.luizfelipe.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.model.LojaEntity;

@DataJpaTest
@ActiveProfiles("test")
class LojaRepositoryTest {

	@Autowired
	private LojaRepository repository;
	
	@BeforeEach
	private void inicializar() {
		
		LojaEntity loja1 = new LojaEntity();
		loja1.setNome("MERCADO DA AVENIDA");
		
		LojaEntity loja2 = new LojaEntity();
		loja2.setNome("BAR DO JOÃO");
		
		this.repository.save(loja1);
		this.repository.save(loja2);
		
	}
	
	@Test
	void verificaSeEncontraLojaPeloNome() {
		
		String nome = "BAR DO JOÃO";
		
		Optional<LojaEntity> optLoja = this.repository.findByNome(nome);
		
		assertTrue(optLoja.isPresent());
		assertEquals(nome, optLoja.get().getNome());
		
	}
	
	@Test
	void verificaSeNaoEncontraLojaPeloNome() {
		
		String nome = "RESTAURANTE DA DONA FLORINDA";
		
		Optional<LojaEntity> optLoja = this.repository.findByNome(nome);
		
		assertFalse(optLoja.isPresent());
		
	}
	
	@Test
	void verificaSeListaEstaEmOrdemAlfabeticaPorNome() {
		
		List<LojaEntity> lojas = this.repository.findAllByOrderByNomeAsc();
		
		assertEquals(2, lojas.size());
		assertEquals("BAR DO JOÃO", lojas.get(0).getNome());
		assertEquals("MERCADO DA AVENIDA", lojas.get(1).getNome());
		
	}
	
}
