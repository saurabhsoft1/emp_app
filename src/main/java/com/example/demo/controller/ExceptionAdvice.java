package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ProductServiceException;
import com.example.demo.model.ProductError;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<ProductError> mapException(ProductServiceException ex)
	{
		ProductError error = new ProductError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<ProductError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
