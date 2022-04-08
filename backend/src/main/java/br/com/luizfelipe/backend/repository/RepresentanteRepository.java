package br.com.luizfelipe.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizfelipe.backend.model.RepresentanteEntity;

@Repository
public interface RepresentanteRepository extends JpaRepository<RepresentanteEntity, Long> {

	Optional<RepresentanteEntity> findByNome(String nome);
	
}
