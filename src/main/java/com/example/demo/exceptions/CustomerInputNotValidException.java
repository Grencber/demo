package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomerInputNotValidException extends RuntimeException{

	public CustomerInputNotValidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
