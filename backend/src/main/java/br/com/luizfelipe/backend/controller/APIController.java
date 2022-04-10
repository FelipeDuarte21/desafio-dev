package br.com.luizfelipe.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.luizfelipe.backend.controller.exception.ObjectBadRequestException;
import br.com.luizfelipe.backend.dto.LojaDTO;
import br.com.luizfelipe.backend.service.APIService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "sistema-cnab/api/v1/")
public class APIController {
	
	private APIService apiService;
	
	public APIController(APIService apiService) {
		this.apiService = apiService;
	}

	@ApiOperation(value = "Importa dados para o banco de dados a partir de um arquivo CNAB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Dados importados com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao tentar importar os dados")
	})
	@PostMapping(value = "/upload_base_dados", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadDados(@RequestParam(name = "arquivo") MultipartFile arquivoCNAB){
		
		try {
			
			this.apiService.salvarDadosDoArquivo(arquivoCNAB);
			
			return ResponseEntity.ok().build();
			
		}catch(IllegalArgumentException ex) {
			throw new ObjectBadRequestException(ex.getMessage());
			
		}
		
	}
	
	@ApiOperation(value = "Busca uma lista de lojas importadas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista retornada com sucesso"),
	})
	@GetMapping(value = "/lojas", produces = "application/json")
	public ResponseEntity<List<LojaDTO>> listarPorLojas(){
		
		var lojasDTO = this.apiService.listarLojas();
		
		return ResponseEntity.ok(lojasDTO);
		
	}

}
