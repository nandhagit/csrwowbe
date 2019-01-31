package com.wow.wow.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.Category;
import com.wow.wow.entity.ProductSubCategory;

@RepositoryRestResource(path = "/subtype")
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
	Collection<ProductSubCategory> findAllByCategory(Category category);

}
