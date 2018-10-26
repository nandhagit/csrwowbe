package com.wow.wow.serviceimpl;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wow.wow.model.Product;
import com.wow.wow.model.Rating;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.RatingRepository;
import com.wow.wow.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public void saveRating(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		String productId = json.get("product").toString();
		ObjectMapper objMapper = new ObjectMapper();

		Rating rating = new Rating();
		try {
			rating = objMapper.readValue(json.get("rating").toString(), Rating.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ratingRepo.save(rating);
		Product product = productRepo.findById(Long.valueOf(productId)).orElse(null);
		product.getRatings().add(rating);
		productRepo.save(product);
	}

}