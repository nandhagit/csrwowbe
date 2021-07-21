package com.wow.wow.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wow.wow.entity.WowUser;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.JwtUser;

@Service
public class UserUtil {
	
	@Autowired
	WowUserRepository userRepo;

	public static JwtUser getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		return (JwtUser) auth.getPrincipal();
	}
	
	public WowUser getUser() {
		return userRepo.findById(1L/*UserUtil.getCurrentUser().getId()*/).orElse(null);
	}

}
