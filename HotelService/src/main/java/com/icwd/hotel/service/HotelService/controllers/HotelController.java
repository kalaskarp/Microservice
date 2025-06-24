package com.icwd.hotel.service.HotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icwd.hotel.service.HotelService.entities.Hotel;
import com.icwd.hotel.service.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotels1")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	// create hotel
	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		Hotel savedHotel = hotelService.createHotel(hotel);
		
		return new ResponseEntity<Hotel>(savedHotel,HttpStatus.CREATED);
		
	}
	
	//get All Hotel
	@GetMapping("/getHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		
		List<Hotel> allHotelList = hotelService.getAllHotel();
		
		return new ResponseEntity<List<Hotel>>(allHotelList,HttpStatus.OK);
	}
	
	
	// Get hotel By Id
	@GetMapping("/getHotel/{id}")
	public ResponseEntity<Hotel> createHotel(@PathVariable int id){
		
		Hotel getHotel = hotelService.getHotelById(id);
		
		return new ResponseEntity<Hotel>(getHotel,HttpStatus.OK);
		
	} 
	
	
}
