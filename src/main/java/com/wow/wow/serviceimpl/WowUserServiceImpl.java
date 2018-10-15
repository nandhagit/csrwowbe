package com.wow.wow.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.model.Role;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.RoleRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.WowUserService;

@Service
public class WowUserServiceImpl implements WowUserService {

	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	WowUserRepository userRepo;
	
	@Override
	public void addUser(WowUser user) {
		Set<Role> roles = new HashSet<>();
		Role role = roleRepo.findByRole("USER");
		roles.add(role);
		//user.setRole(roles);
		userRepo.save(user);

	}

}
