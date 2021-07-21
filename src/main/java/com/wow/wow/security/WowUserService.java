package com.wow.wow.security;

import com.wow.wow.dto.UserDTO;
import com.wow.wow.entity.WowUser;

public interface WowUserService {

	public void addUser(WowUser user);

	public UserDTO getUserById(Long userId);

	public UserDTO getUser();

	public boolean isPhoneTaken(Long phoneNumber);

	public boolean isEmailTaken(String email);

}
