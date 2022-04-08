package br.com.luizfelipe.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.support.MultipartFilter;

import br.com.luizfelipe.backend.dto.LojaDTO;

@Service
public class APIService {

	private RepresentanteService representanteService;
	private LojaService lojaService;
	private CartaoService cartaoService;
	private BeneficiarioService beneficiarioService;
	private TransacaoService transacaoService;
	
	@Autowired
	public APIService(RepresentanteService representanteService, LojaService lojaService, CartaoService cartaoService,
			BeneficiarioService beneficiarioService, TransacaoService transacaoService) {
		this.representanteService = representanteService;
		this.lojaService = lojaService;
		this.cartaoService = cartaoService;
		this.beneficiarioService = beneficiarioService;
		this.transacaoService = transacaoService;
	}
	
	public void salvarDadosDoArquivo(MultipartFilter arquivo) {
		//implementar
	}
	
	public List<LojaDTO> listarLojas(){
		
		return this.lojaService.listarLojas().stream().map(LojaDTO::new).collect(Collectors.toList());
		
	}
	
}
