package com.wow.wow.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class WowUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2267233991938245953L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> lst = new ArrayList<>();
		for (Role role : getRole()) {
			lst.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
		}
		return lst;
	}

	public WowUserDetails(User user) {
		super(user);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
