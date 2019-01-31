package com.wow.wow.security;

import com.wow.wow.dto.UserProjection;
import com.wow.wow.entity.WowUser;

public interface WowUserService {

	public void addUser(WowUser user);

	public UserProjection getUserById(Long userId);

	public UserProjection getUser();

	public boolean isPhoneTaken(Long phoneNumber);

	public boolean isEmailTaken(String email);

}
