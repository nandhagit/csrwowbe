package com.wow.wow.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	/*
	 * @GetMapping("/user")
	 * 
	 * @ResponseBody
	 * 
	 * @CrossOrigin(origins = "http://localhost:4200") public Principal
	 * user(Principal user) { return user; }
	 */

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String user(@RequestBody String credentials) {
		JSONObject credential = new JSONObject(credentials);
		System.out.println(credential);
		JSONObject obj = new JSONObject();
		String email = credential.get("email").toString();
		String password = credential.get("password").toString();
		if (email.equalsIgnoreCase("dany") && password.equalsIgnoreCase("dany")) {
			obj.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6ImRhbnkiLCJpYXQiOjE3MTYyMzkwMjJ9.sEkHcK6jtiE7KD-0Wv26HQUsunfE71dG355EacNz8Gc");
			return obj.toString();
		}
		return null;
	}

}
