package br.com.luizfelipe.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.luizfelipe.backend.model.LojaEntity;
import br.com.luizfelipe.backend.model.TransacaoEntity;

@DataJpaTest
@ActiveProfiles("test")
class TransacaoRepositoryTest {

	@Autowired
	private TransacaoRepository repository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	private LojaEntity loja;

	@BeforeEach
	private void inicializar() {
		
		loja = new LojaEntity();
		loja.setNome("MERCADO DA AVENIDA");
		
		loja = this.lojaRepository.save(loja);
		
		TransacaoEntity t1 = new TransacaoEntity();
		t1.setDataHora(LocalDateTime.of(2022,Month.APRIL,9,12,27,22));
		t1.setLoja(loja);
		
		TransacaoEntity t2 = new TransacaoEntity();
		t2.setDataHora(LocalDateTime.of(2022,Month.APRIL,10,4,5,22));
		t2.setLoja(loja);
		
		loja.addTransacao(t1);
		loja.addTransacao(t2);
		
		
		this.repository.save(t1);
		this.repository.save(t2);
		
		loja = this.lojaRepository.save(loja);
		
	}
	
	@Test
	void verificaSeListaDeTransacaoEstaEmOrdemDecrescenteDeAcordoComDataHora() {
		
		List<TransacaoEntity> transacoes = this.repository.findByLojaOrderByDataHoraDesc(loja);
		
		assertEquals(2, transacoes.size());
		assertEquals(LocalDateTime.of(2022,Month.APRIL,10,4,5,22), transacoes.get(0).getDataHora());
		assertEquals(LocalDateTime.of(2022,Month.APRIL,9,12,27,22), transacoes.get(1).getDataHora());
		
	}
	
}
