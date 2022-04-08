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
		
		var optLojaEntity = this.lojaRepository.findByNome(lojaEntity.getNome());
		
		if(optLojaEntity.isPresent())
			throw new IllegalArgumentException("Erro! loja já está cadastrada!");
		
		return this.lojaRepository.save(lojaEntity);
		
	}

	@Override
	public Optional<LojaEntity> buscar(String nome) {
		
		return this.lojaRepository.findByNome(nome);
		
	}
	
}
