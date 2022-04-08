package br.com.luizfelipe.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.model.BeneficiarioEntity;
import br.com.luizfelipe.backend.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService implements AcoesService<BeneficiarioEntity> {

	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
		this.beneficiarioRepository = beneficiarioRepository;
	}

	@Override
	public BeneficiarioEntity salvar(BeneficiarioEntity beneficiarioEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BeneficiarioEntity> buscar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
