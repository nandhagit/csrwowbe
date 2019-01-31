package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.CartItem;

@RepositoryRestResource(path = "cartitem")
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
