package com.wow.wow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.dto.AddressProjection;
import com.wow.wow.model.Address;
import com.wow.wow.service.AddressService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/wow")
public class AddressController {

	@Autowired
	AddressService addressService;

	@RequestMapping(path = "/saveaddress", method = RequestMethod.POST)
	public void saveAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
	}

	@RequestMapping(path = "/getaddress", method = RequestMethod.GET)
	public List<AddressProjection> getLoggedInUserAddress() {
		return addressService.getAddress();
	}

}
