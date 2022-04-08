package br.com.luizfelipe.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.model.LojaEntity;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<LojaEntity> buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
