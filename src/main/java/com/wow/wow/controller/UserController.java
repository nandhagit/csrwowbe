package com.wow.wow.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.dto.UserProjection;
import com.wow.wow.model.WowUser;
import com.wow.wow.security.WowUserService;

@RestController
public class UserController {

	@Autowired
	WowUserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void saveUser(@RequestBody WowUser user, HttpServletResponse response) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserProjection getUser(@RequestParam("userid") Long userId) {
		return userService.getUserById(userId);
	}

	@RequestMapping(value = "/current-user", method = RequestMethod.GET)
	public UserProjection getCurrentUser() {
		return userService.getUser();
	}

}
