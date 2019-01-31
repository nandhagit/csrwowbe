package com.wow.wow.dto;

import java.util.Set;

import com.wow.wow.entity.CartItem;

public class CartDTO {

	private Long id;

	private Set<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
