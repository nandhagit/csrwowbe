package com.wow.wow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.entity.Product;

@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(@Param("name") String name);

	List<Product> findByCategoryIn(List<String> type);

	@Query("select min(price), max(price) from Product")
	Object findMinAndMaxPrice();
}