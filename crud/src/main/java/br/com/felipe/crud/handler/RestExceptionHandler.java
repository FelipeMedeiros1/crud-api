package br.com.felipe.crud.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.felipe.crud.model.error.ErrorMessage;
import br.com.felipe.crud.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handlerResouceNotFoundException(ResourceNotFoundException ex){
    ErrorMessage error = new ErrorMessage("Não encontrado",ex.getMessage(), HttpStatus.NOT_FOUND.value());

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }
    
}