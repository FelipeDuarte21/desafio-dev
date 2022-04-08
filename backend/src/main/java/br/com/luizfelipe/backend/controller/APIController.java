package br.com.luizfelipe.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.luizfelipe.backend.dto.LojaDTO;
import br.com.luizfelipe.backend.service.APIService;

@RestController
@RequestMapping(value = "sistema-cnab/api/v1/")
public class APIController {
	
	private APIService apiService;
	
	public APIController(APIService apiService) {
		this.apiService = apiService;
	}

	@PostMapping(value = "/upload_base_dados")
	public ResponseEntity<?> uploadDados(MultipartFile arquivoCNAB){
		return null; //implementar
	}
	
	@GetMapping(value = "/lojas")
	public ResponseEntity<List<LojaDTO>> listarPorLojas(){
		return null; //implementar
	}

}
