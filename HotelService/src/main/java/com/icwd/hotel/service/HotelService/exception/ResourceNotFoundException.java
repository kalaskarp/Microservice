package com.icwd.hotel.service.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resource Not Found...");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
