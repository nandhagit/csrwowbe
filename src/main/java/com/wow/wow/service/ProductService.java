package com.wow.wow.service;

import java.util.Collection;

import com.wow.wow.dto.ProductDTO;
import com.wow.wow.entity.Category;
import com.wow.wow.entity.Product;
import com.wow.wow.entity.ProductSubCategory;

public interface ProductService {

	public Collection<ProductDTO> getAllProducts();

	public Collection<Category> getCategory();

	public Object getMinAndMaxPrice();

	public Collection<ProductSubCategory> getSubCategories(Long category);

	public void saveProduct(Product product);

	public void updateProduct(Product product);

	public Product getProduct(Long productId);
}