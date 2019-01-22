package com.wow.wow.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.model.Category;
import com.wow.wow.model.ProductSubCategory;

@RepositoryRestResource(path = "/subtype")
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
	Collection<ProductSubCategory> findAllByCategory(Category category);

}
