package com.icwd.user.service.UserService.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icwd.user.service.UserService.ExceptionHandler.ResourceNotFoundException;
import com.icwd.user.service.UserService.entities.Hotel;
import com.icwd.user.service.UserService.entities.Rating;
import com.icwd.user.service.UserService.entities.User;
import com.icwd.user.service.UserService.external.services.HotelService;
import com.icwd.user.service.UserService.external.services.RatingsService;
import com.icwd.user.service.UserService.repository.UserRepository;
import com.icwd.user.service.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	HotelService hotelService;
	@Autowired
	RatingsService ratingsService;

	private User user2;
	private Integer id;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User getUser(Integer user) {
		user2 = userRepo.findById(user).orElseThrow(() -> new ResourceNotFoundException("User Not Found" + user));
		// http://localhost:8083/api/getbyHotelId/2

//		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/getbyUserId/"+user2.getUserId(), Rating[].class);
//		logger.info("{}",ratingsOfUser);

		Rating[] ratingsOfUser = ratingsService.getRatings(user2.getUserId());

		List<Rating> list = Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = list.stream().map(ratings -> {

			// api call to hotel service to get the hotel
			// http://localhost:8082/api/getHotel/1

//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/getHotel/"+ratings.getHotelId(), Hotel.class);

			Hotel hotel = hotelService.getHotel(ratings.getHotelId());

			// set the hotel to rating
			ratings.setHotel(hotel);

			// return rating
			return ratings;

		}).collect(Collectors.toList());

		user2.setRetings(ratingList);
		return user2;
	}

}
