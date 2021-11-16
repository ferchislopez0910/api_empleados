package com.parameta.api.empleados.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class contain an exceptions for error
 * @author Maria Fernanda Lopez A.
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
	  
	  System.out.println("ERROR OCCURED handleMethodArgumentNotValid");
	    Map<String, List<String>> body = new HashMap<>();
	
	    List<String> errors = ex.getBindingResult()
	        .getFieldErrors()
	        .stream()
	        .map(DefaultMessageSourceResolvable::getDefaultMessage)
	        .collect(Collectors.toList());
	
	    body.put("errors", errors);
	
	    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
  
  
  
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
	  System.out.println("ERROR OCCURED constraintViolationException");
    List<String> errors = new ArrayList<>();
System.out.println(ex);
    ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));

    Map<String, List<String>> result = new HashMap<>();
    result.put("errors", errors);
System.out.println(errors);
    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
  }  
}
