package com.wow.wow.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.model.Cart;
import com.wow.wow.model.Product;
import com.wow.wow.repository.CartRepository;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductRepository productrepo;

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	CartRepository cartrepo;

	@GetMapping("/getproducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Product> getAllProducts() {
		return productrepo.findAll();
	}

	@GetMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return user;
	}

	@GetMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void addtoCart(@RequestBody String json) {
		JSONObject jsonObject = new JSONObject(json);
		com.wow.wow.model.User user = userrepo.findById(Long.valueOf(jsonObject.get("user").toString())).orElse(null);
		Product product = productrepo.findById(Long.valueOf(jsonObject.get("product").toString())).orElse(null);
		Cart cart = new Cart();
		cart.setProductId(product.getId());
		cart.setUserId(user.getId());
		cartrepo.save(cart);
	}

	// @GetMapping("/filterproduct")
	@RequestMapping(value = "/filterproduct", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Product> filterByType(@RequestParam("filterlist") List<String> filterList) {
		return productrepo.findByTypeIn(filterList);
	}
	
	@RequestMapping(value = "/getcartitems", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Product> getCartItem(@RequestParam("user") Long userId) {
		Set<Product> pro = new HashSet<>();
		List<Cart> cartItems = cartrepo.findByUserId(userId);
		for(Cart cart: cartItems) {
			Product product = productrepo.findById(cart.getProductId()).orElse(null);
			pro.add(product);
		}
		return pro;
		
	}

}
