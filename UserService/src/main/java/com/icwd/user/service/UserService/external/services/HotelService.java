package com.icwd.user.service.UserService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.icwd.user.service.UserService.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE1")
public interface HotelService {

	@GetMapping("/hotels/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable Integer hotelId);

}
