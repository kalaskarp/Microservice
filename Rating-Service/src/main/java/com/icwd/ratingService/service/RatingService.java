package com.icwd.ratingService.service;

import java.util.List;


import com.icwd.ratingService.entities.Rating;


public interface RatingService{

	//create 
	Rating createrating(Rating rating);
	
	// get all ratings
	List<Rating> getAllRating();
	
	// get all by userid
	List<Rating> getRatingByUserId(int userId);
	
	// get all by hotel
	List<Rating> getRatingByHotelId(int hotelId);
	
	
}
