/*package com.wow.wow.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wow.wow.model.WowUser;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.JwtUser;
import com.wow.wow.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	WowUserRepository userRepo;

	@Override
	public WowUser getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		return userRepo.findById(((JwtUser) auth.getPrincipal()).getId()).orElse(null);
	}

}
*/