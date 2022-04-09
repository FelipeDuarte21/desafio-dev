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
				
				System.out.println("linha: " + line.length());
				
				if(line.length() != 80)
					throw new IllegalArgumentException("Erro! linha no arquivo não tem 80 caracteres!");
				
				var dados = new HashMap<String,String>();
				
				dados.put("tipo", line.substring(0,1));
				dados.put("data", line.substring(1,9));
				dados.put("valor", line.substring(9,19));
				dados.put("cpfBeneficiario", line.substring(19,30));
				dados.put("numeroCartao", line.substring(30,42));
				dados.put("hora", line.substring(42,48));
				dados.put("representante", line.substring(48,62));
				dados.put("loja", line.substring(62));
				
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
