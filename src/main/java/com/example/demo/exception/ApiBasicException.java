package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiBasicException extends RuntimeException {
	
	public ApiBasicException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatusCode();
}
