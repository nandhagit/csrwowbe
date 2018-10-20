package com.wow.wow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.model.WowUser;
import com.wow.wow.security.WowUserService;

@RestController
@CrossOrigin
@RequestMapping("/wow")
public class UserController {

	@Autowired
	WowUserService userService;

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public void saveUser(@RequestBody WowUser user) {
		userService.addUser(user);
	}
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public WowUser getUser(@RequestParam("userid") Long userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(value = "/getcurrentuser", method = RequestMethod.GET)
	public WowUser getCurrentUser() {
		return userService.getUser();
	}
	
	

}
