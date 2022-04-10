package br.com.luizfelipe.backend.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.model.BeneficiarioEntity;
import br.com.luizfelipe.backend.repository.BeneficiarioRepository;

@ActiveProfiles("test")
class BeneficiarioServiceTest {

	@Mock
	private BeneficiarioRepository repository;

	@Autowired
	private BeneficiarioService service;
	
	@BeforeEach
	private void inicializar() {
		MockitoAnnotations.openMocks(this);
		this.service = new BeneficiarioService(repository);
	}
	
	@Test
	void verificaSeBeneficiarioJaFoiCadastrado() {
		
		Mockito.when(repository.findByCpf(Mockito.anyString()))
		.thenReturn(Optional.of(new BeneficiarioEntity()));
		
		BeneficiarioEntity beneficiario = new BeneficiarioEntity();
		beneficiario.setCpf("58656852611");
		
		assertThrows(IllegalArgumentException.class, () -> service.salvar(beneficiario));
		
	}
	
}
