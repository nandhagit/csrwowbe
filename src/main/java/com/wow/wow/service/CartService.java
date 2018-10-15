package com.wow.wow.service;

import java.util.Collection;

import com.wow.wow.model.Cart;
import com.wow.wow.model.CartItem;

public interface CartService {
	
	public Collection<CartItem> getCartItems(Long userId);
	
	public int getCartCount(Long userId);
	
	public void removeFromCart(String jsonUserItem);
	
	public Long addToCart(String jsonUserItem);
	
	public Cart createCart();
	
	public void clearCart(Long cartId);

}
