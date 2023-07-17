package com.inventory.system.expections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inventory.system.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductIdRequiredException.class)
	public ResponseEntity<ErrorResponse> handleProducIdRequiredException(ProductIdRequiredException e){
		ErrorResponse error=new ErrorResponse();
		error.setCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error,  HttpStatus.PRECONDITION_FAILED);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException e){
		ErrorResponse error=new ErrorResponse();
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error,  HttpStatus.NOT_FOUND);
	}
}
