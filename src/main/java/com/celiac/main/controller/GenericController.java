package com.celiac.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celiac.main.model.User;
import com.celiac.main.service.UserService;


@Controller
@RequestMapping("/business-owner")
public class GenericController {
	
	@Autowired
	UserService userService;

	/* USER API LIST */
	
	@CrossOrigin
	@PostMapping("/user")
	public ResponseEntity<User> saveUser (@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	/* 
	@CrossOrigin
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userService.getAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	} 
	*/
}
