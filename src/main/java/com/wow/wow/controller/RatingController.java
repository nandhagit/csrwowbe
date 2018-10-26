package com.wow.wow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.service.RatingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/wow")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@RequestMapping(path = "/saveRating", method = RequestMethod.POST)
    public void saveRating(@RequestBody String json){
		ratingService.saveRating(json);
    }
	
}
