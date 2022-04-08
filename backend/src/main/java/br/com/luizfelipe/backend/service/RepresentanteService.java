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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RepresentanteEntity> buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
