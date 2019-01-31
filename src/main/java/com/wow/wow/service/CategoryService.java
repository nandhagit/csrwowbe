package com.wow.wow.service;

import java.util.Collection;

import com.wow.wow.entity.Category;
import com.wow.wow.entity.ProductSubCategory;

public interface CategoryService {

	public Collection<Category> getCategory();

	public Collection<ProductSubCategory> getSubCategories(Long category);

}