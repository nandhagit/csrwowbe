package com.wow.wow.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private WowUser user;

	@OneToMany
	@JoinTable(name = "shopping_cart_item", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
	private Set<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WowUser getUser() {
		return user;
	}

	public void setUser(WowUser user) {
		this.user = user;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
