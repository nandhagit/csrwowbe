package com.wow.wow.dto;

import java.util.Set;

import com.wow.wow.model.CartItem;

public interface CartProjection {

	public Long getId();

	public Set<CartItem> getCartItems();

}
