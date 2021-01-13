package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ConfilctException extends ApiBasicException{
	public ConfilctException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
