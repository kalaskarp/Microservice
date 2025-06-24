package com.icwd.hotel.service.HotelService.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponce {
	
	private String message;
	private boolean success;
	private HttpStatus status;

}
