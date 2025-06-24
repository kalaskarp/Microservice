package com.icwd.ratingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icwd.ratingService.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>{

	// custom 
	List<Rating> findByuserId(Integer userId);
	
	List<Rating> findByhotelId(Integer hotelId);
	
}
