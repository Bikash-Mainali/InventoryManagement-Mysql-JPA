package com.inventory.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {
   @ExceptionHandler
   public ResponseEntity<Object> exception(GenericException exception) {
	   
	ErrorMessage errorMessage = new ErrorMessage("404",exception.getMessage());
	HttpStatus status=HttpStatus.NOT_FOUND;
    
	return new ResponseEntity<>(errorMessage,status);
   }
}

