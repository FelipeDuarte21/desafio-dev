package br.com.luizfelipe.backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.luizfelipe.backend.dto.LojaDTO;
import br.com.luizfelipe.backend.enums.TipoTransacaoEnum;
import br.com.luizfelipe.backend.model.BeneficiarioEntity;
import br.com.luizfelipe.backend.model.CartaoEntity;
import br.com.luizfelipe.backend.model.ContaEntity;
import br.com.luizfelipe.backend.model.LojaEntity;
import br.com.luizfelipe.backend.model.RepresentanteEntity;
import br.com.luizfelipe.backend.model.TransacaoEntity;
import br.com.luizfelipe.backend.utils.ArquivoUtil;
import br.com.luizfelipe.backend.utils.SeparadorDataHora;

@Service
public class APIService {

	private RepresentanteService representanteService;
	private LojaService lojaService;
	private CartaoService cartaoService;
	private BeneficiarioService beneficiarioService;
	private TransacaoService transacaoService;
	
	private ArquivoUtil arquivoUtil;
	
	@Autowired
	public APIService(RepresentanteService representanteService, LojaService lojaService, CartaoService cartaoService,
			BeneficiarioService beneficiarioService, TransacaoService transacaoService, ArquivoUtil arquivoUtil) {
		this.representanteService = representanteService;
		this.lojaService = lojaService;
		this.cartaoService = cartaoService;
		this.beneficiarioService = beneficiarioService;
		this.transacaoService = transacaoService;
		this.arquivoUtil = arquivoUtil;
	}
	
	public void salvarDadosDoArquivo(MultipartFile arquivoCNAB) {
		
		List<Map<String,String>> listaDados = this.arquivoUtil.obterDadosAPartirDeArquivo(arquivoCNAB);
		
		listaDados.forEach(dados -> {
			
			var representante = obterRepresentante(dados.get("representante"));
			
			var loja = obterLoja(representante, dados.get("loja"));
			
			var cartao = obterCartao(dados.get("numeroCartao"));
			
			var beneficiario = obterBeneficiario(dados.get("cpfBeneficiario"));
			
			var tipo = TipoTransacaoEnum.toEnum(Integer.parseInt(dados.get("tipo")));
			
			var valor = new BigDecimal(dados.get("valor")).divide(new BigDecimal("100"));
			
			var dataHora = new SeparadorDataHora(dados.get("data").concat(dados.get("hora"))).getDataHora();
			
			var transacao = new TransacaoEntity();
			transacao.setLoja(loja);
			transacao.setCartao(cartao);
			transacao.setBeneficiario(beneficiario);
			transacao.setTipoOperacao(tipo.getValor());
			transacao.setValor(valor);
			transacao.setDataHora(dataHora);
			
			loja.addTransacao(transacao);
			
			this.transacaoService.salvar(transacao);
			
		});
		
	}
	
	private RepresentanteEntity obterRepresentante(String nome) {
		
		var optRepresentante = this.representanteService.buscar(nome);
		
		if(optRepresentante.isPresent()) return optRepresentante.get();
		
		var representante = new RepresentanteEntity();
		representante.setNome(nome);
		
		return this.representanteService.salvar(representante);
		
	}
	
	private LojaEntity obterLoja(RepresentanteEntity representante, String nome) {
		
		var optLoja = this.lojaService.buscar(nome);
		
		if(optLoja.isPresent()) return optLoja.get();
		
		var loja = new LojaEntity();
		loja.setNome(nome);
		loja.setRepresentante(representante);
		loja.setConta(new ContaEntity());
		
		return this.lojaService.salvar(loja);
		
	}
	
	private CartaoEntity obterCartao(String numero) {
		
		var optCartao = this.cartaoService.buscar(numero);
		
		if(optCartao.isPresent()) return optCartao.get();
		
		var cartao = new CartaoEntity();
		cartao.setNumero(numero);
		
		return this.cartaoService.salvar(cartao);
		
	}
	
	private BeneficiarioEntity obterBeneficiario(String cpf) {
		
		var optBeneficiario = this.beneficiarioService.buscar(cpf);
		
		if(optBeneficiario.isPresent()) return optBeneficiario.get();
		
		var beneficiario = new BeneficiarioEntity();
		beneficiario.setCpf(cpf);
		
		return this.beneficiarioService.salvar(beneficiario);
		
	}
	
	public List<LojaDTO> listarLojas(){
		
		var listaLojas = this.lojaService.listarLojas();
		
		listaLojas.forEach(loja -> {
			loja.setTransacoes(this.transacaoService.buscarPorLoja(loja));
		});
		
		return listaLojas.stream().map(LojaDTO::new).collect(Collectors.toList());
		
	}
	
}
