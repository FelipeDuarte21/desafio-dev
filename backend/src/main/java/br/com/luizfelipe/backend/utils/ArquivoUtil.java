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
		
		if(!arquivoCNAB.getContentType().equals("text/plain"))
			throw new IllegalArgumentException("Erro! formato de arquivo não aceito!");
		
		if(!arquivoCNAB.getOriginalFilename().endsWith(".txt"))
			throw new IllegalArgumentException("Erro! formato de arquivo não aceito!");
		
		var listaDeDados = new ArrayList<Map<String,String>>();
		
		Reader reader = null;
		BufferedReader buffered = null;
		
		try {
			
			reader = new InputStreamReader(arquivoCNAB.getInputStream());
			buffered = new BufferedReader(reader);
			
			String line = buffered.readLine();
			while(line != null) {
				
				if(line.length() != 80)
					throw new IllegalArgumentException("Erro! linha no arquivo não tem 80 caracteres!");
				
				var dados = new HashMap<String,String>();
				
				String tipo = line.substring(0,1);
				
				if(!tipo.matches("\\d{1}"))
					throw new IllegalArgumentException("Erro! tipo da transação é inválido!");
				
				dados.put("tipo", tipo);
				
				String data = line.substring(1,9);
				
				if(!data.matches("\\d{8}"))
					throw new IllegalArgumentException("Erro! data da transação é inválida!");
				
				dados.put("data", data);
				
				String valor = line.substring(9,19);
				
				if(!valor.matches("\\d{10}"))
					throw new IllegalArgumentException("Erro! valor da transação é inválido!");
				
				dados.put("valor", valor);
				
				String cpfBeneficiario = line.substring(19,30);
				
				if(!cpfBeneficiario.matches("\\d{11}"))
					throw new IllegalArgumentException("Erro! cpf do beneficiário está inválido!");
				
				dados.put("cpfBeneficiario", cpfBeneficiario);
				
				String numeroCartao = line.substring(30,42);
				
				if(!numeroCartao.matches("\\d{4}\\*\\*\\*\\*\\d{4}"))
					throw new IllegalArgumentException("Erro! numero do cartão é inválido!");
				
				dados.put("numeroCartao", numeroCartao);
				
				String hora = line.substring(42,48);
				
				if(!hora.matches("\\d{6}"))
					throw new IllegalArgumentException("Erro! hora está inválida!");
				
				dados.put("hora", hora);
				
				dados.put("representante", line.substring(48,62).trim());
				dados.put("loja", line.substring(62).trim());
				
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
	
}
