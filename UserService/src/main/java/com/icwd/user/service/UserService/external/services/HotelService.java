package com.icwd.user.service.UserService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.icwd.user.service.UserService.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE1")
public interface HotelService {

	@GetMapping("/hotels/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable Integer hotelId);
	
	// demo purpose
	@GetMapping("/hotels/getHotel")
	List<Hotel> getAllHotel();

}
