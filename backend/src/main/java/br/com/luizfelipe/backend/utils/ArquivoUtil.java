package br.com.luizfelipe.backend.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArquivoUtil {
	
	public List<Map<String,String>> obterDadosAPartirDeArquivo(MultipartFile arquivoCNAB) {
		
		verificarContentType(arquivoCNAB.getContentType());
		
		verificarExtensao(arquivoCNAB.getOriginalFilename());
		
		var listaDeDados = new ArrayList<Map<String,String>>();
		
		Reader reader = null;
		BufferedReader buffered = null;
		
		try {
			
			reader = new InputStreamReader(arquivoCNAB.getInputStream());
			buffered = new BufferedReader(reader);
			
			String line = buffered.readLine();
			while(line != null) {
				
				verificarLinha(line);
				
				var dados = new HashMap<String,String>();
				
				String tipo = line.substring(0,1);
				String data = line.substring(1,9);
				String valor = line.substring(9,19);
				String cpfBeneficiario = line.substring(19,30);
				String numeroCartao = line.substring(30,42);
				String hora = line.substring(42,48);
				String representante = line.substring(48,62).trim();
				String loja = line.substring(62).trim();
				
				verificarTipo(tipo);
				verificarData(data);
				verificarValor(valor);
				verificarCpfBeneficiario(cpfBeneficiario);
				verificarNumeroCartao(numeroCartao);
				verificarHora(hora);
				
				dados.put("tipo", tipo);
				dados.put("data", data);
				dados.put("valor", valor);
				dados.put("cpfBeneficiario", cpfBeneficiario);
				dados.put("numeroCartao", numeroCartao);
				dados.put("hora", hora);
				dados.put("representante", representante);
				dados.put("loja", loja);
				
				listaDeDados.add(dados);
				
				line = buffered.readLine();
				
			}
			
		} catch (IOException e) {
			throw new RuntimeException("Erro! erro ao tentar interpretar o arquivo CNAB!");
			
		}finally {
			
			try {
				
				reader.close();
				buffered.close();
				
			}catch(IOException e) {
				throw new RuntimeException("Erro! erro ao tentar interpretar o arquivo CNAB!");
				
			}
			
		}
		
		return listaDeDados;
		
	}
	
	public boolean verificarContentType(String contentType) {
		
		if(!"text/plain".equals(contentType))
			throw new IllegalArgumentException("Erro! formato de arquivo não aceito!");
		
		return true;
		
	}
	
	public boolean verificarExtensao(String nomeArquivo) {
		
		if(!nomeArquivo.endsWith(".txt"))
			throw new IllegalArgumentException("Erro! formato de arquivo não aceito!");
		
		return true;
		
	}
	
	public boolean verificarLinha(String linha) {
		
		if(linha.length() != 80)
			throw new IllegalArgumentException("Erro! linha no arquivo não tem 80 caracteres!");
		
		return true;
		
	}
	
	public boolean verificarTipo(String tipo) {
		
		if(!tipo.matches("\\d{1}"))
			throw new IllegalArgumentException("Erro! tipo da transação é inválido!");
		
		return true;
		
	}
	
	public boolean verificarData(String data) {
		
		if(!data.matches("\\d{8}"))
			throw new IllegalArgumentException("Erro! data da transação é inválida!");
		
		return true;
		
	}
	
	public boolean verificarValor(String valor) {
		
		if(!valor.matches("\\d{10}"))
			throw new IllegalArgumentException("Erro! valor da transação é inválido!");
		
		return true;
		
	}
	
	public boolean verificarCpfBeneficiario(String cpf) {
		
		if(!cpf.matches("\\d{11}"))
			throw new IllegalArgumentException("Erro! cpf do beneficiário está inválido!");
		
		return true;
		
	}
	
	public boolean verificarNumeroCartao(String numero) {
		
		if(!numero.matches("\\d{4}\\*\\*\\*\\*\\d{4}"))
			throw new IllegalArgumentException("Erro! numero do cartão é inválido!");
		
		return true;
		
	}
	
	public boolean verificarHora(String hora) {
		
		if(!hora.matches("\\d{6}"))
			throw new IllegalArgumentException("Erro! hora está inválida!");
		
		return true;
		
	}
	
}
