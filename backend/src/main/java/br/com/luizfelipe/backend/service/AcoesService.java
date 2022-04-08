package br.com.luizfelipe.backend.service;

import java.util.Optional;

public interface AcoesService<T> {

	T salvar(T objeto);
	Optional<T> buscar(String atributo);
	
}
