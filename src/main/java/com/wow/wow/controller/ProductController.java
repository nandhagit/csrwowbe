package com.wow.wow.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.entity.Category;
import com.wow.wow.entity.Product;
import com.wow.wow.entity.ProductSubCategory;
import com.wow.wow.repository.CategoryRepository;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.ProductSubCategoryRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productrepo;

	@Autowired
	CategoryRepository catRepo;

	@Autowired
	ProductSubCategoryRepository subRepo;

	@GetMapping("/products")
	public Collection<Product> getAllProducts() {
		return productrepo.findAll();
	}

	@GetMapping("/category")
	public Collection<Category> getCategory() {
		return catRepo.findAll();
	}

	@GetMapping("/minAndMax")
	public Object getMinAndMaxPrice() {
		return productrepo.findMinAndMaxPrice();
	}

	@GetMapping("/sub-filters")
	public Collection<ProductSubCategory> getSubCategories(@RequestParam("category") Long category) {
		Category cat = catRepo.findById(category).orElse(null);
		return subRepo.findAllByCategory(cat);
	}

	@PostMapping("/products")
	public void saveProduct(@RequestBody Product product) {
		ProductSubCategory subCat = subRepo.findById(Long.parseLong(product.getSubType())).orElse(null);
		product.setSubType(subCat.getSubType());
		product.setCategory(subCat.getCategory().getName());
		product.setCreatedDate(new Date());
		product.setLastModifiedDate(new Date());
		productrepo.save(product);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		ProductSubCategory subCat = subRepo.findById(Long.parseLong(product.getSubType())).orElse(null);
		product.setSubType(subCat.getSubType());
		product.setCategory(subCat.getCategory().getName());
		product.setLastModifiedDate(new Date());
		productrepo.save(product);
	}

	@GetMapping("/products/one")
	public Product getProduct(@RequestParam("id") Long productId) {
		return productrepo.findById(productId).orElse(null);
	}

}
