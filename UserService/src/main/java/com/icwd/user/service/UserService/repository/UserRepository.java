package com.icwd.user.service.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icwd.user.service.UserService.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	
}
