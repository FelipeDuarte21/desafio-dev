package br.com.luizfelipe.backend.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.model.CartaoEntity;
import br.com.luizfelipe.backend.repository.CartaoRepository;

@ActiveProfiles("test")
class CartaoServiceTest {

	@Mock
	private CartaoRepository repository;
	
	private CartaoService service;
	
	@BeforeEach
	private void inicializar() {
		MockitoAnnotations.openMocks(this);
		this.service = new CartaoService(repository);
	}
	
	@Test
	void verificaSeCartaoJaFoiCadastrado() {
		
		Mockito.when(repository.findByNumero(Mockito.anyString()))
		.thenReturn(Optional.of(new CartaoEntity()));
		
		CartaoEntity cartao = new CartaoEntity();
		cartao.setNumero("4850****4856");
		
		assertThrows(IllegalArgumentException.class, () -> service.salvar(cartao));
		
	}
	
}
