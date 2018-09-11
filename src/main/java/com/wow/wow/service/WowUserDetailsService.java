package com.wow.wow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wow.wow.model.User;
import com.wow.wow.model.WowUserDetails;
import com.wow.wow.repository.UserRepository;

@Service
public class WowUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userrepo.findByEmail(username).orElse(null);
		return new WowUserDetails(user);
	}

}
