package br.com.luizfelipe.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.luizfelipe.backend.model.CartaoEntity;
import br.com.luizfelipe.backend.repository.CartaoRepository;

@Service
public class CartaoService implements AcoesService<CartaoEntity> {
	
	private CartaoRepository cartaoRepository;
	
	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
	}

	@Override
	public CartaoEntity salvar(CartaoEntity cartaoEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CartaoEntity> buscar(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
