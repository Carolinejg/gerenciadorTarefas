package com.meuprojeto.gerenciarTarefa.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.meuprojeto.gerenciarTarefa.services.exceptions.EntityNotFoundException;

@ControllerAdvice	
public class ResourceExceptionHandler {
	@ExceptionHandler(EntityNotFoundException.class)// para saber o tipo de excecao a ser interceptada
	public ResponseEntity<StandardError>entityNotFound(EntityNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
