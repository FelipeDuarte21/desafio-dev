package br.com.luizfelipe.backend.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ObjectBadRequestException.class)
	public ResponseEntity<ErrorModel> badRequestExceptionHandler(ObjectBadRequestException ex,
			HttpServletRequest request){
		
		ErrorModel em  = new ErrorModel(HttpStatus.BAD_REQUEST.value(),"Bad Request",ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(em);
	
	}

}
