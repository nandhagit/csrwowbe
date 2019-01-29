package com.wow.wow.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.dto.UserProjection;
import com.wow.wow.model.WowUser;
import com.wow.wow.security.WowUserService;

@RestController
public class UserController {

	@Autowired
	WowUserService userService;

	@PostMapping("/user")
	public void saveUser(@RequestBody WowUser user, HttpServletResponse response) {
		userService.addUser(user);
	}

	@GetMapping("/user")
	public UserProjection getUser(@RequestParam("userid") Long userId) {
		return userService.getUserById(userId);
	}

	@GetMapping("/current-user")
	public UserProjection getCurrentUser() {
		return userService.getUser();
	}

	@PutMapping("/user")
	public UserProjection updateUser(@RequestBody WowUser user) {
		userService.addUser(user);
		return userService.getUser();
	}

}
