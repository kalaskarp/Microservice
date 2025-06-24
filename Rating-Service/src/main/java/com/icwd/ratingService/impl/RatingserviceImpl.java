package com.icwd.ratingService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icwd.ratingService.entities.Rating;
import com.icwd.ratingService.repository.RatingRepo;
import com.icwd.ratingService.service.RatingService;

@Service
public class RatingserviceImpl implements RatingService {

	@Autowired
	private RatingRepo repo;

	@Override
	public Rating createrating(Rating rating) {

		return repo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		// TODO Auto-generated method stub

		return repo.findByhotelId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return repo.findByhotelId(hotelId);
	}

}
