package com.icwd.hotel.service.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icwd.hotel.service.HotelService.payload.ApiResponce;


@RestControllerAdvice
public class GobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		Map<String, Object> map = new HashMap<>();
		map.put("Message", ex.getMessage());
		map.put("Success", false);
		map.put("Status", HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
	}

}
