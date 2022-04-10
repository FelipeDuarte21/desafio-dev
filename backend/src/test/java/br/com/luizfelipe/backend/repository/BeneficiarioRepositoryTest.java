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

import br.com.luizfelipe.backend.model.BeneficiarioEntity;

@DataJpaTest
@ActiveProfiles("test")
class BeneficiarioRepositoryTest {
	
	@Autowired
	private BeneficiarioRepository repository;
	
	@BeforeEach
	private void inicializar() {
		
		BeneficiarioEntity beneficiario = new BeneficiarioEntity();
		beneficiario.setCpf("09620676017");
		
		this.repository.save(beneficiario);
		
	}
	
	@Test
	void verificaSeEncontraBeneficiarioPeloCPF() {
		
		String cpf = "09620676017";
		
		Optional<BeneficiarioEntity> optBeneficiario = this.repository.findByCpf(cpf); 
		
		assertTrue(optBeneficiario.isPresent());
		assertEquals(cpf, optBeneficiario.get().getCpf());
		
	}
	
	@Test
	void verificaSeNaoEncontraBeneficiarioPeloCPF() {
		
		String cpf = "56848548655";
		
		Optional<BeneficiarioEntity> optBeneficiario = this.repository.findByCpf(cpf); 
		
		assertFalse(optBeneficiario.isPresent());
		
	}

}
