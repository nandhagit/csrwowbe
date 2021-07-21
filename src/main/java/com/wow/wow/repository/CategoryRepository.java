package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.Category;

@RepositoryRestResource(path = "/category")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
