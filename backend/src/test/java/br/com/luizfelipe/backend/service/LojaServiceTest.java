package br.com.luizfelipe.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.enums.TipoTransacaoEnum;
import br.com.luizfelipe.backend.model.ContaEntity;
import br.com.luizfelipe.backend.model.LojaEntity;
import br.com.luizfelipe.backend.model.TransacaoEntity;
import br.com.luizfelipe.backend.repository.LojaRepository;

@ActiveProfiles("test")
class LojaServiceTest {

	@Mock
	private LojaRepository repository;
	
	private LojaService service;
	
	@Captor
	private ArgumentCaptor<LojaEntity> captor;
	
	@BeforeEach
	private void inicializar() {
		MockitoAnnotations.openMocks(this);
		this.service = new LojaService(repository);
	}
	
	@Test
	void verificarSeLojaJaEstaCadastrada() {
		
		Mockito.when(repository.findByNome(Mockito.anyString()))
			.thenReturn(Optional.of(new LojaEntity()));
		
		LojaEntity loja = new LojaEntity();
		loja.setNome("Tenda do chaves");
		
		assertThrows(IllegalArgumentException.class, () -> service.salvar(loja));
		
	}
	
	@Test
	void verificarSeEstaCalculandoSaldoCorretamente() {
		
		TransacaoEntity t1 = new TransacaoEntity();
		t1.setValor(new BigDecimal("5"));
		t1.setTipoOperacao(TipoTransacaoEnum.DEBITO.getValor());
		
		TransacaoEntity t2 = new TransacaoEntity();
		t2.setValor(new BigDecimal("5"));
		t2.setTipoOperacao(TipoTransacaoEnum.RECEBIMENTO_DOC.getValor());
		
		TransacaoEntity t3 = new TransacaoEntity();
		t3.setValor(new BigDecimal("5"));
		t3.setTipoOperacao(TipoTransacaoEnum.SAIDA.getValor());
		
		List<TransacaoEntity> transacoes = new ArrayList<>();
		transacoes.add(t1);
		transacoes.add(t2);
		transacoes.add(t3);
		
		LojaEntity loja = new LojaEntity();
		loja.setConta(new ContaEntity());
		loja.setTransacoes(transacoes);
		
		this.service.atualizaSaldo(loja);
		
		Mockito.verify(repository).save(captor.capture());
		
		BigDecimal saldo = captor.getValue().getConta().getSaldo();
		
		assertEquals(new BigDecimal("5"), saldo);
		
	}
	
}
