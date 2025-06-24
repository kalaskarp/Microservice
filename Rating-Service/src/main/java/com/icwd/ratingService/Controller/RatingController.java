package com.icwd.ratingService.Controller;

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

import com.icwd.ratingService.entities.Rating;
import com.icwd.ratingService.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	// create service
	@PostMapping("/addRating")
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating){
		
		Rating createrating = ratingService.createrating(rating);
		
		return new ResponseEntity<Rating>(createrating,HttpStatus.CREATED);
		
	}
	
	// get rating
	@GetMapping("/getRating")
	public ResponseEntity<List<Rating>> getRatings(){
		
		List<Rating> getRating = ratingService.getAllRating();
		
		return new ResponseEntity<List<Rating>>(getRating,HttpStatus.OK);
		
	}
	
	// get rating by user id
		@GetMapping("/getbyUserId/{id}")
		public ResponseEntity<List<Rating>> getUserRatings(@PathVariable Integer id){
			
			List<Rating> getUserRating = ratingService.getRatingByUserId(id);
			
			return new ResponseEntity<List<Rating>>(getUserRating,HttpStatus.OK);
			
		}
		
		
		// get rating
		@GetMapping("/getbyHotelId/{id}")
		public ResponseEntity<List<Rating>> getHotelRatings(@PathVariable Integer id){
			
			List<Rating> getHotelRating = ratingService.getRatingByHotelId(id);
			
			return new ResponseEntity<List<Rating>>(getHotelRating,HttpStatus.OK);
			
		}
	
	
}
