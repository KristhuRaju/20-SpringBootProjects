package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	 @Autowired
	    private UserService userService;

	    @GetMapping
	    public List<User> getAllUsers() {
	        return userService.findAll();
	    }

	    @PostMapping("/us")
	    public User addUser(@RequestBody User user) {
	        return userService.save(user) ;
	    }
}
