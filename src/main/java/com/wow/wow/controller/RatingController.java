package com.wow.wow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;

	@PostMapping(path = "/rating")
	public void saveRating(@RequestBody String json) {
		ratingService.saveRating(json);
	}

}
