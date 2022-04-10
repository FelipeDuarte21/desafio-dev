package br.com.luizfelipe.backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.enums.NaturezaTransacaoEnum;
import br.com.luizfelipe.backend.enums.TipoTransacaoEnum;
import br.com.luizfelipe.backend.model.LojaEntity;
import br.com.luizfelipe.backend.model.TransacaoEntity;
import br.com.luizfelipe.backend.repository.LojaRepository;

@Service
public class LojaService implements AcoesService<LojaEntity> {

	private LojaRepository lojaRepository;
	
	@Autowired
	public LojaService(LojaRepository lojaRepository) {
		this.lojaRepository = lojaRepository;
	}

	@Override
	public LojaEntity salvar(LojaEntity lojaEntity) {
		
		var optLojaEntity = this.lojaRepository.findByNome(lojaEntity.getNome());
		
		if(optLojaEntity.isPresent())
			throw new IllegalArgumentException("Erro! loja já está cadastrada!");
		
		return this.lojaRepository.save(lojaEntity);
		
	}

	@Override
	public Optional<LojaEntity> buscar(String nome) {
		
		return this.lojaRepository.findByNome(nome);
		
	}
	
	public void atualizaSaldo(LojaEntity lojaEntity) {
		
		BigDecimal entrada = new BigDecimal("0");
		BigDecimal saida = new BigDecimal("0");
	
		for(TransacaoEntity transacao: lojaEntity.getTransacoes()) {
			
			String sinal = TipoTransacaoEnum.toEnum(transacao.getTipoOperacao()).getNatureza().getSinal();
			
			if(sinal.equals(NaturezaTransacaoEnum.ENTRADA.getSinal())) {
				entrada = entrada.add(transacao.getValor());
				continue;
			}
			
			if(sinal.equals(NaturezaTransacaoEnum.SAIDA.getSinal())) {
				saida = saida.add(transacao.getValor());
			}
			
		}
		
		BigDecimal saldo = new BigDecimal("0");
		saldo = saldo.add(entrada).subtract(saida);
		
		lojaEntity.atualizaSaldo(saldo);
		
		this.lojaRepository.save(lojaEntity);
		
	}
	
	public List<LojaEntity> listarLojas(){
		
		return this.lojaRepository.findAll();
		
	}
	
}
