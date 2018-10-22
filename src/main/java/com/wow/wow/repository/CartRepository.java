package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.model.Cart;

@RepositoryRestResource(path="/cart")
public interface CartRepository extends JpaRepository<Cart, Long> {
}
