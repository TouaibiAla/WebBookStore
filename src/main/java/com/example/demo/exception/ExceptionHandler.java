package com.example.demo.exception;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandler  extends ResponseEntityExceptionHandler{
	  @org.springframework.web.bind.annotation.ExceptionHandler(ApiBasicException.class)
	     public ResponseEntity<ErrorDetail> handleApiException(ApiBasicException ex , WebRequest request){
	          ErrorDetail details=new ErrorDetail(ex.getMessage(),request.getDescription(false));
	          return new ResponseEntity<>(details,ex.getStatusCode());
	     }

	    
}
