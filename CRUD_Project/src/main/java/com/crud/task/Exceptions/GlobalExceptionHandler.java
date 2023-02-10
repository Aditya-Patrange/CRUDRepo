package com.crud.task.Exceptions;

import java.net.http.HttpHeaders;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crud.task.CustomExceptions.IllegalThreadStateException;
import com.crud.task.CustomExceptions.ResourceNotFoundException;
import com.crud.task.DTO.ApiResponse;

@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
public class GlobalExceptionHandler{
//	//@Override
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	//@ExceptionHandler(Exception.class)
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		System.out.println("in handle method arg not valid !!!!!!!!!!!!!!!!!!");
//		Map<String, String> collect = ex.getBindingResult().getFieldErrors().stream() // Stream<FieldError>
//				.collect(Collectors.toMap(f -> f.getField(), FieldError::getDefaultMessage));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(collect);
//	}
	
	
	//resource not found
	//@Qualifier()
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		System.out.println("in handle resource not found...");
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("in handle method arg not valid !!!!!!!!!!!!!!!!!!");
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
//		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		
		Map<String, String> collect = e.getBindingResult().getFieldErrors().stream() // Stream<FieldError>
				.collect(Collectors.toMap(f -> f.getField(), FieldError::getDefaultMessage));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(collect);
	}
//	//Illegal Thread State
	@ExceptionHandler(IllegalThreadStateException.class)
	public ResponseEntity<?> handleNoValueException(IllegalThreadStateException e){
		System.out.println("in handle Illegal Thread State ...");
		return new ResponseEntity<Object>("in handle IllegalThreadStateException...",HttpStatus.BAD_REQUEST);
	}
	
	
	//for all remaining excs :  global exc handling method
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception e) {
		System.out.println("in handle  exc");
		return new ResponseEntity<Object>("in handle in handle  exc...",HttpStatus.BAD_REQUEST);
	}
	
	
}
