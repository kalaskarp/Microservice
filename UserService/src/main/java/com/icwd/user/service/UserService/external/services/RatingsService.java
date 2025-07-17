package com.icwd.user.service.UserService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.icwd.user.service.UserService.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingsService {
	
	@GetMapping("/ratings/getbyUserId/{ratingId}")
	Rating[] getRatings(@PathVariable Integer ratingId);

	@GetMapping("/ratings/getRating")
	List<Rating> getAllRatings();

}
