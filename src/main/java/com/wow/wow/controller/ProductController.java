package com.wow.wow.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.dto.ProductDTO;
import com.wow.wow.entity.Category;
import com.wow.wow.entity.Product;
import com.wow.wow.entity.ProductSubCategory;
import com.wow.wow.service.CategoryService;
import com.wow.wow.service.ProductService;
import com.wow.wow.service.SubCategoryService;

@RestController
public class ProductController {

	@Autowired
	ProductService productservice;

	@Autowired
	CategoryService categoryservice;

	@Autowired
	SubCategoryService subcategoryservice;

	@GetMapping("/products")
	public Collection<ProductDTO> getAllProducts() {
		return productservice.getAllProducts();
	}

	@GetMapping("/category")
	public Collection<Category> getCategory() {
		return categoryservice.getCategory();
	}

	@GetMapping("/minAndMax")
	public Object getMinAndMaxPrice() {
		return productservice.getMinAndMaxPrice();
	}

	@GetMapping("/sub-filters")
	public Collection<ProductSubCategory> getSubCategories(@RequestParam("category") Long category) {
		return categoryservice.getSubCategories(category);
	}

	@PostMapping("/products")
	public void saveProduct(@RequestBody Product product) {
		productservice.saveProduct(product);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		productservice.updateProduct(product);
	}

	@GetMapping("/products/one")
	public Product getProduct(@RequestParam("id") Long productId) {
		return productservice.getProduct(productId);
	}

}
