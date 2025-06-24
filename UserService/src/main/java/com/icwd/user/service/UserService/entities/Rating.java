package com.icwd.user.service.UserService.entities;



import lombok.Data;

@Data
public class Rating {

	private int ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
}
