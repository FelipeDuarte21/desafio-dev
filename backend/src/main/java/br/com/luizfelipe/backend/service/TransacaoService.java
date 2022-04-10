package br.com.luizfelipe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.model.LojaEntity;
import br.com.luizfelipe.backend.model.TransacaoEntity;
import br.com.luizfelipe.backend.repository.TransacaoRepository;

@Service
public class TransacaoService implements AcoesService<TransacaoEntity> {
	
	private TransacaoRepository transacaoRepository;
	
	private LojaService lojaService;
	
	@Autowired
	public TransacaoService(TransacaoRepository transacaoRepository, LojaService lojaService) {
		this.transacaoRepository = transacaoRepository;
		this.lojaService = lojaService;
	}

	@Override
	public TransacaoEntity salvar(TransacaoEntity transacaoEntity) {
		
		transacaoEntity = this.transacaoRepository.save(transacaoEntity);
		
		this.lojaService.atualizaSaldo(transacaoEntity.getLoja());
		
		return transacaoEntity;
		
	}

	
	//Método não é utilizado!!
	@Override
	public Optional<TransacaoEntity> buscar(String atributo) {
		return null;
	}
	
	public List<TransacaoEntity> buscarPorLoja(LojaEntity loja){
		
		return this.transacaoRepository.findByLojaOrderByDataHoraDesc(loja);
		
	}

}
