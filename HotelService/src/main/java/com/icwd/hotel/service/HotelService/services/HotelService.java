package com.icwd.hotel.service.HotelService.services;

import java.util.List;

import com.icwd.hotel.service.HotelService.entities.Hotel;

public interface HotelService {
	
	// Create Hotel
	Hotel createHotel(Hotel hotel);
	
	// Get All
	
	List<Hotel> getAllHotel();
	
	// Get by Id
	Hotel getHotelById(int hotelId);
	
	
}
