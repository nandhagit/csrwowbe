package com.wow.wow.service;

import java.util.List;

import com.wow.wow.dto.AddressProjection;
import com.wow.wow.model.Address;

public interface AddressService {
	
	public void saveAddress(Address address);
	
	public List<AddressProjection> getAddress();

}
