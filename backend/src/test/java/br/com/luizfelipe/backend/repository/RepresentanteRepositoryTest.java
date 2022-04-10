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

import br.com.luizfelipe.backend.model.RepresentanteEntity;

@DataJpaTest
@ActiveProfiles("test")
class RepresentanteRepositoryTest {

	@Autowired
	private RepresentanteRepository repository;
	
	@BeforeEach
	private void inicializar() {
		
		RepresentanteEntity representante = new RepresentanteEntity();
		representante.setNome("JOÃO MACEDO");
		
		this.repository.save(representante);
		
	}
	
	@Test
	public void verificaSeEncontraRepresentantePeloNome() {
		
		String nome = "JOÃO MACEDO";
		
		Optional<RepresentanteEntity> optRepresentante = this.repository.findByNome(nome);
		
		assertTrue(optRepresentante.isPresent());
		assertEquals(nome, optRepresentante.get().getNome());
		
	}
	
	@Test
	public void verificaSeNaoEncontraRepresentantePeloNome() {
		
		String nome = "Chiquinha";
		
		Optional<RepresentanteEntity> optRepresentante = this.repository.findByNome(nome);
		
		assertFalse(optRepresentante.isPresent());
		
	}

}
