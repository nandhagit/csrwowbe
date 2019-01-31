package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wow.wow.entity.ProductHistory;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long> {

}