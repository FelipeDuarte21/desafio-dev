package br.com.luizfelipe.backend.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.model.RepresentanteEntity;
import br.com.luizfelipe.backend.repository.RepresentanteRepository;

@ActiveProfiles("test")
class RepresentanteServiceTest {

	@Mock
	private RepresentanteRepository repository;
	
	private RepresentanteService service;
	
	@BeforeEach
	private void inicializar() {
		MockitoAnnotations.openMocks(this);
		this.service = new RepresentanteService(repository);
	}
	
	@Test
	void verificaSeRepresentanteJaEstaCadastrado() {
		
		Mockito.when(repository.findByNome(Mockito.anyString()))
		.thenReturn(Optional.of(new RepresentanteEntity()));
		
		RepresentanteEntity representante = new RepresentanteEntity();
		representante.setNome("QUICO");
		
		assertThrows(IllegalArgumentException.class, () -> service.salvar(representante));
		
	}

}
