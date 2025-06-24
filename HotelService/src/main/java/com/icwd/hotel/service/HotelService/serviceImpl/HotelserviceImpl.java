package com.icwd.hotel.service.HotelService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icwd.hotel.service.HotelService.entities.Hotel;
import com.icwd.hotel.service.HotelService.exception.ResourceNotFoundException;
import com.icwd.hotel.service.HotelService.repositories.HotelRepo;
import com.icwd.hotel.service.HotelService.services.HotelService;

@Service
public class HotelserviceImpl implements HotelService {

	@Autowired
	HotelRepo repo;

	@Override
	public Hotel createHotel(Hotel hotel) {

		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		List<Hotel> hotelList = repo.findAll();
		return hotelList;
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		// TODO Auto-generated method stub

		Hotel hotel = repo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: "+hotelId));

		return hotel;
	}

}
