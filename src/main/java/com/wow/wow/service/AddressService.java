package com.wow.wow.service;

import java.util.List;

import com.wow.wow.dto.AddressDTO;
import com.wow.wow.entity.Address;

public interface AddressService {

	public void saveAddress(Address address);

	public List<AddressDTO> getAddress();

}
