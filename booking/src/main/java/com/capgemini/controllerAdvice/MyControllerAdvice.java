package com.capgemini.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.exceptions.InvalidDetailsException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler()
	public ResponseEntity<String> seatNotFound(InvalidDetailsException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}