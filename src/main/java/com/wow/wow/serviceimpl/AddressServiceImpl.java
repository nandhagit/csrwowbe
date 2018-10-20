package com.wow.wow.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.dto.AddressProjection;
import com.wow.wow.model.Address;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.AddressRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.service.AddressService;
import com.wow.wow.utility.UserUtil;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	WowUserRepository userRepo;

	@Override
	public void saveAddress(Address address) {
		address.setUser(getUser());
		addressRepo.save(address);
	}
	
	private WowUser getUser() {
		return userRepo.findById(UserUtil.getCurrentUser().getId()).orElse(null);
	}

	@Override
	public List<AddressProjection> getAddress() {
		return addressRepo.findByUser(getUser());
	}

}
