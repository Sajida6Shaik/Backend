 package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.User;
import com.springboot.main.service.UserService;
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user/add")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	//GET ALL USERS
	@GetMapping("/user/all")

	public List<User> getAllUsers(@RequestParam(value= "page",required = false,defaultValue ="0")Integer page,
		                    @RequestParam(value="size",required = false, defaultValue = "1000000" )Integer size) {
		
		
		Pageable pageable = PageRequest.of(page,size);
		return userService.getAllUsers(pageable);
		
	}
	
	//GET USER BY ID
	@GetMapping("/user/one/{uid}")
	public ResponseEntity<?> getByUserId(@PathVariable("uid")int uid) {
	try {
	User user = userService.getById(uid);
		 	
		return ResponseEntity.ok().body(user);
	}catch(InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}



}
}


