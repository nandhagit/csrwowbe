package com.wow.wow.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.entity.Cart;
import com.wow.wow.entity.CartItem;
import com.wow.wow.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/cart-items")
	public Collection<CartItem> getCartItem(@RequestParam("cart") Long cartId) {
		return cartService.getCartItems(cartId);

	}

	@GetMapping("/cart-count")
	public int getCartCount(@RequestParam("cart") Long cartId) {
		return cartService.getCartCount(cartId);
	}

	@PostMapping("/cart-item")
	public Cart addtoCart(@RequestBody String json) {
		return cartService.addToCart(json);
	}

	@PostMapping("/remove/cart-item")
	public Cart removefromcart(@RequestBody String json) {
		return cartService.removeFromCart(json);
	}

	@PostMapping("/cart")
	public Cart createCart() {
		return cartService.createCart();
	}

	@GetMapping("/clear-cart")
	public void clearCart(@RequestParam("cart") Long cartId) {
		cartService.clearCart(cartId);
	}

	@GetMapping("/merge-cart")
	public Cart mergeCartOnLogin(@RequestParam("cart") Long cartId) {
		return cartService.mergeCart(cartId);
	}

	@GetMapping("/cart")
	public Cart getCart(@RequestParam("cart") Long cartId) {
		return cartService.getCart(cartId);
	}
}
