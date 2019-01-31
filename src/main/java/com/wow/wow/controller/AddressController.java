package com.wow.wow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.dto.AddressDTO;
import com.wow.wow.entity.Address;
import com.wow.wow.service.AddressService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping(path = "/address")
	public void saveAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
	}

	@GetMapping(path = "/address")
	public List<AddressDTO> getLoggedInUserAddress() {
		return addressService.getAddress();
	}

}
