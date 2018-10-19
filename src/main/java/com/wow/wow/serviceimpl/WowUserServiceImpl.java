package com.wow.wow.serviceimpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wow.wow.model.Authority;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.AuthorityRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.WowUserService;


@Service
public class WowUserServiceImpl implements WowUserService {
	
	
	@Autowired
	AuthorityRepository authRepo;
	
	@Autowired
	WowUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(WowUser user) {
		user.setUsername(String.valueOf(user.getPhone()));
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setLastPasswordResetDate(new Date());
		List<Authority> authority = authRepo.findAllById(Arrays.asList(1L));
		user.setAuthorities(authority);
		userRepo.save(user);
	}
	
	


}
