package com.icwd.user.service.UserService.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icwd.user.service.UserService.payload.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiResponce apiResponce = ApiResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.NOT_FOUND);
	}
}
