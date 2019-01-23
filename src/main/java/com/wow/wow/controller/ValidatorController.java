package com.wow.wow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.security.WowUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/wow")
public class ValidatorController {

	@Autowired
	private WowUserService userService;

	@RequestMapping(value = "/checkPhoneNumber", method = RequestMethod.GET)
	public boolean isPhoneTaken(@RequestParam("phonenumber") Long phonenumber) {
		return userService.isPhoneTaken(phonenumber);
	}

	@RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
	public boolean isEmailTaken(@RequestParam("email") String email) {
		return userService.isEmailTaken(email);
	}

}
