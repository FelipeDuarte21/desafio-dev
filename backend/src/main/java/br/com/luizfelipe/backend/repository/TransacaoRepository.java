package br.com.luizfelipe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizfelipe.backend.model.TransacaoEntity;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {

}
