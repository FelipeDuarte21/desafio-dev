package br.com.luizfelipe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizfelipe.backend.model.LojaEntity;
import br.com.luizfelipe.backend.model.TransacaoEntity;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {
	
	List<TransacaoEntity> findByLojaOrderByDataHoraDesc(LojaEntity loja);
	
}
