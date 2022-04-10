package br.com.luizfelipe.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizfelipe.backend.model.LojaEntity;

@Repository
public interface LojaRepository extends JpaRepository<LojaEntity, Long>{
	
	Optional<LojaEntity> findByNome(String nome);
	
	List<LojaEntity> findAllByOrderByNomeAsc();
	
}
