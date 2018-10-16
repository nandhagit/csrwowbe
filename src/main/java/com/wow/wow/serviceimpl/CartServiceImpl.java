package com.wow.wow.serviceimpl;

import java.util.Collections;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wow.wow.model.Cart;
import com.wow.wow.model.CartItem;
import com.wow.wow.model.Product;
import com.wow.wow.model.WowUser;
import com.wow.wow.repository.CartItemRepository;
import com.wow.wow.repository.CartRepository;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.WowUserRepository;
import com.wow.wow.security.JwtUser;
import com.wow.wow.service.CartService;
import com.wow.wow.utility.UserUtil;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	CartItemRepository cartItemRepo;

	@Autowired
	WowUserRepository userRepo;

	@Override
	public Set<CartItem> getCartItems(Long cartId) {
		Cart cart = cartRepo.findById(cartId).orElse(null);
		if (cart == null) {
			return Collections.emptySet();
		}
		return cart.getCartItems();
	}

	@Override
	public int getCartCount(Long cartId) {
		Cart cart = cartRepo.findById(Long.valueOf(cartId)).orElse(null);
		return cart.getCartItems().stream().mapToInt(item -> item.getCount()).sum();
	}

	@Override
	public Long addToCart(String jsonUserItem) {
		JSONObject json = new JSONObject(jsonUserItem);
		String productId = json.get("product").toString();
		String cartId = json.get("cart").toString();
		Product product = productRepo.findById(Long.valueOf(productId)).orElse(null);
		Cart cart = new Cart();
		boolean present = false;
		cart = cartRepo.findById(Long.valueOf(cartId)).orElse(null);
		for (CartItem item : cart.getCartItems()) {
			if (item.getProduct().equals(product)) {
				item.setCount(item.getCount() + 1);
				present = true;
			}
		}
		if (!present) {
			CartItem cartItem = new CartItem();
			cartItem.setCount(1);
			cartItem.setProduct(product);
			cartItemRepo.save(cartItem);
			cart.getCartItems().add(cartItem);
			cart.setUser(getUser());
		}
		cartRepo.save(cart);
		return cart.getId();
	}

	@Override
	public void removeFromCart(String jsonUserItem) {

		JSONObject json = new JSONObject(jsonUserItem);
		String productId = json.get("product").toString();
		String cartId = json.get("cart").toString();
		Product product = productRepo.findById(Long.valueOf(productId)).orElse(null);
		Cart cart = new Cart();
		cart = cartRepo.findById(Long.valueOf(cartId)).orElse(null);
		CartItem itemToRemove = null;
		for (CartItem c : cart.getCartItems()) {
			if (c.getProduct().equals(product)) {
				if (c.getCount() == 1) {
					itemToRemove = c;
					break;
				} else {
					c.setCount(c.getCount() - 1);
					break;
				}
			}

		}
		if (itemToRemove != null) {
			cart.getCartItems().remove(itemToRemove);
		}
		cartRepo.save(cart);

	}

	@Override
	public Cart createCart() {
		Cart cart = new Cart();
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public void clearCart(Long cartId) {
		Cart c = cartRepo.findById(cartId).orElse(null);
		cartRepo.delete(c);
	}

	public WowUser getUser() {
		return userRepo.findById(UserUtil.getCurrentUser().getId()).orElse(null);
	}

}
