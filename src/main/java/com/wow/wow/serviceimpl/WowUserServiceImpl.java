package com.wow.wow.serviceimpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wow.wow.dto.UserDTO;
import com.wow.wow.entity.Authority;
import com.wow.wow.entity.WowUser;
import com.wow.wow.repository.AuthorityRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.WowUserService;
import com.wow.wow.utility.UserUtil;

@Service
public class WowUserServiceImpl implements WowUserService {

	@Autowired
	AuthorityRepository authRepo;

	@Autowired
	WowUserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	ModelMapper mapper = new ModelMapper();

	@Override
	public void addUser(WowUser user) {
		user.setUsername(String.valueOf(user.getPhone()));
		user.setEnabled(true);
		user.setSigninpassword(passwordEncoder.encode(user.getSigninpassword()));
		user.setLastPasswordResetDate(new Date());
		List<Authority> authority = authRepo.findAllById(Arrays.asList(1L));
		user.setAuthorities(authority);
		userRepo.save(user);
	}

	@Override
	public UserDTO getUserById(Long userId) {
		return mapper.map(userRepo.findById(userId).orElse(null), UserDTO.class);
	}

	@Override
	public UserDTO getUser() {
		return mapper.map(userRepo.findById(UserUtil.getCurrentUser().getId()).orElse(null), UserDTO.class);
	}

	@Override
	public boolean isPhoneTaken(Long phoneNumber) {
		return userRepo.findByPhone(phoneNumber).isPresent();
	}

	@Override
	public boolean isEmailTaken(String email) {
		return userRepo.findByEmail(email).isPresent();
	}

}
