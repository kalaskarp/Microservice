package com.icwd.user.service.UserService.Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icwd.user.service.UserService.entities.User;
import com.icwd.user.service.UserService.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	// create User API
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(user));
	}

	// get user by ID
	@CircuitBreaker(name = "sampleService", fallbackMethod = "fallbackResponse")
	@Retry(name = "sampleService", fallbackMethod = "fallbackResponse")
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") Integer userId) {

		return new ResponseEntity<User>(service.getUser(userId), HttpStatus.OK);
	}

	public ResponseEntity<?> fallbackResponse(Exception ex) {
		String message = ex.getMessage();

		Pattern p = Pattern.compile("\\bhttps?://([^:/\\]]+)");
		Matcher m = p.matcher(message);

		if (m.find()) {
			message = m.group(1); // e.g., HOTEL-SERVICE1
		}

		return new ResponseEntity<String>("Fallback: " + message + " is Down", HttpStatus.METHOD_FAILURE);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<?> getAllUser() {

		return new ResponseEntity<List<User>>(service.getAllUser(), HttpStatus.OK);

	}

}
