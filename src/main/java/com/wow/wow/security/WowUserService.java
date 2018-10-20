package com.wow.wow.security;

import com.wow.wow.model.WowUser;

public interface WowUserService {
	
	public void addUser(WowUser user);
	
	public WowUser getUserById(Long userId);
	
	public WowUser getUser();

}
