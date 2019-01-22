package com.wow.wow.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wow.wow.security.JwtUser;

public class UserUtil {

	public static JwtUser getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		return (JwtUser) auth.getPrincipal();
	}

}
