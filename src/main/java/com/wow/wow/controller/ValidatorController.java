package com.wow.wow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.security.WowUserService;

@RestController
public class ValidatorController {

	@Autowired
	private WowUserService userService;

	@RequestMapping(value = "/validate-ph", method = RequestMethod.GET)
	public boolean isPhoneTaken(@RequestParam("phonenumber") Long phonenumber) {
		return userService.isPhoneTaken(phonenumber);
	}

	@RequestMapping(value = "/validate-email", method = RequestMethod.GET)
	public boolean isEmailTaken(@RequestParam("email") String email) {
		return userService.isEmailTaken(email);
	}

}
