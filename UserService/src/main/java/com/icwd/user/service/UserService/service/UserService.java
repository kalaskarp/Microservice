package com.icwd.user.service.UserService.service;

import java.util.List;

import com.icwd.user.service.UserService.entities.User;

public interface UserService {
	
	// create User
	User saveUser(User user);
	
	
	//get All User
	List<User> getAllUser();
	
	User getUser(Integer user);
	
}
