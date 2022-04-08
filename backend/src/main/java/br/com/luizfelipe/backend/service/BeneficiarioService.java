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
		
		var optBeneficiarioEntity = this.beneficiarioRepository.findByCpf(beneficiarioEntity.getCpf());
		
		if(optBeneficiarioEntity.isPresent())
			throw new IllegalArgumentException("Erro! beneficiário já foi cadastrado!");
		
		return this.beneficiarioRepository.save(beneficiarioEntity);
		
	}

	@Override
	public Optional<BeneficiarioEntity> buscar(String cpf) {
		
		return this.beneficiarioRepository.findByCpf(cpf);
		
	}
	
}
