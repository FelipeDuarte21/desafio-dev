package br.com.luizfelipe.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.model.CartaoEntity;

@DataJpaTest
@ActiveProfiles("test")
class CartaoRepositoryTest {

	@Autowired
	private CartaoRepository repository;

	@BeforeEach
	private void inicializar() {
		
		CartaoEntity cartao = new CartaoEntity();
		cartao.setNumero("4753****3153");
		
		this.repository.save(cartao);
		
	}
	
	@Test
	void verificaSeEncontraCartaoPeloNumero() {
		
		String numero = "4753****3153";
		
		Optional<CartaoEntity> optCartao = this.repository.findByNumero(numero);
		
		assertTrue(optCartao.isPresent());
		assertEquals(numero, optCartao.get().getNumero());
		
	}
	
	@Test
	void verificaSeNaoEncontraCartaoPeloNumero() {
		
		String numero = "8680****4806";
		
		Optional<CartaoEntity> optCartao = this.repository.findByNumero(numero);
		
		assertFalse(optCartao.isPresent());
		
	}
	
}
