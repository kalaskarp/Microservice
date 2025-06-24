package com.icwd.ratingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	
	
}
