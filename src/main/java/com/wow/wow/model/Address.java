package com.wow.wow.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String address;
	
	@Column
	private String state;
	
	@Column
	private String city;
	
	@Column
	private Long pin;
	
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	private WowUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public WowUser getUser() {
		return user;
	}

	public void setUser(WowUser user) {
		this.user = user;
	}

}
