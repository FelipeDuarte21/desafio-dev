package br.com.luizfelipe.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.model.TransacaoEntity;
import br.com.luizfelipe.backend.repository.TransacaoRepository;

@Service
public class TransacaoService implements AcoesService<TransacaoEntity> {
	
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	public TransacaoService(TransacaoRepository transacaoRepository, RepresentanteService representanteService,
			LojaService lojaService, CartaoService cartaoService, BeneficiarioService beneficiarioService) {
		this.transacaoRepository = transacaoRepository;
	}

	@Override
	public TransacaoEntity salvar(TransacaoEntity transacaoEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Optional<TransacaoEntity> buscar(String atributo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
