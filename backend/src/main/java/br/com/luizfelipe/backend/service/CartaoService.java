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
		
		var optCartaoEntity = this.cartaoRepository.findByNumero(cartaoEntity.getNumero());
		
		if(optCartaoEntity.isPresent())
			throw new IllegalArgumentException("Erro! cartão já cadastrado!");
		
		return this.cartaoRepository.save(cartaoEntity);
		
	}

	@Override
	public Optional<CartaoEntity> buscar(String numero) {
		
		return this.cartaoRepository.findByNumero(numero);
		
	}

}
