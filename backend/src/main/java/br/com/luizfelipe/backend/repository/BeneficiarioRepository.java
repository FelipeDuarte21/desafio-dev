package br.com.luizfelipe.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizfelipe.backend.model.BeneficiarioEntity;

@Repository
public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, Long> {

	Optional<BeneficiarioEntity> findByCpf(String cpf); 
	
}
