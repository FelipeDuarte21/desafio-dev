package br.com.luizfelipe.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.model.RepresentanteEntity;
import br.com.luizfelipe.backend.repository.RepresentanteRepository;

@Service
public class RepresentanteService implements AcoesService<RepresentanteEntity> {
	
	private RepresentanteRepository representanteRepository;
	
	@Autowired
	public RepresentanteService(RepresentanteRepository representanteRepository) {
		this.representanteRepository = representanteRepository;
	}

	@Override
	public RepresentanteEntity salvar(RepresentanteEntity representanteEntity) {
		
		var optRepresentanteEntity = this.representanteRepository.findByNome(representanteEntity.getNome());
		
		if(optRepresentanteEntity.isPresent())
			throw new IllegalArgumentException("Erro! representante já cadastrado!");
		
		return this.representanteRepository.save(representanteEntity);
		
	}

	@Override
	public Optional<RepresentanteEntity> buscar(String nome) {
		
		return this.representanteRepository.findByNome(nome);
		
	}

}
