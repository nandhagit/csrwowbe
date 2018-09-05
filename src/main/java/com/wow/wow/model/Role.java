package com.wow.wow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Role {
	
	@Id @GeneratedValue
	private Long id;
	
	private @NotNull String role;
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
