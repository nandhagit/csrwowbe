package com.wow.wow.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.model.Role;
import com.wow.wow.model.User;
import com.wow.wow.repository.RoleRepository;
import com.wow.wow.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public void saveUser(@RequestBody User user) {
		Set<Role> roles = new HashSet<>();
		Role role = roleRepo.findByRole("USER");
		roles.add(role);
		user.setRole(roles);
		userRepo.save(user);
	}
}
