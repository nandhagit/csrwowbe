package com.wow.wow.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.model.Cart;
import com.wow.wow.model.CartItem;
import com.wow.wow.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/wow")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/getcartitems", method = RequestMethod.GET)
	public Collection<CartItem> getCartItem(@RequestParam("cart") Long cartId) {
		return cartService.getCartItems(cartId);

	}

	@RequestMapping(value = "/getcartcount", method = RequestMethod.GET)
	public int getCartCount(@RequestParam("cart") Long cartId) {
		return cartService.getCartCount(cartId);
	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public void addtoCart(@RequestBody String json) {
		cartService.addToCart(json);
	}

	@RequestMapping(value = "/removefromcart", method = RequestMethod.POST)
	public void removefromcart(@RequestBody String json) {
		cartService.removeFromCart(json);
	}

	@RequestMapping(value = "/createCart", method = RequestMethod.GET)
	public Cart createCart() {
		return cartService.createCart();
	}

	@RequestMapping(value = "/clearCart", method = RequestMethod.GET)
	public void clearCart(@RequestParam("cart") Long cartId) {
		cartService.clearCart(cartId);
	}
}
