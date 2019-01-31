package com.wow.wow.service;

import java.util.Collection;

import com.wow.wow.entity.Cart;
import com.wow.wow.entity.CartItem;

public interface CartService {

	public Collection<CartItem> getCartItems(Long userId);

	public int getCartCount(Long userId);

	public Cart removeFromCart(String jsonUserItem);

	public Cart addToCart(String jsonUserItem);

	public Cart createCart();

	public void clearCart(Long cartId);

	public Cart mergeCart(Long cartId);

	public Cart getCart(Long cartId);

}
