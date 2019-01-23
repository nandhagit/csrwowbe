package com.wow.wow.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wow.wow.model.Category;
import com.wow.wow.model.Product;
import com.wow.wow.model.ProductSubCategory;
import com.wow.wow.repository.CategoryRepository;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.ProductSubCategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/wow")
public class ProductController {

	@Autowired
	ProductRepository productrepo;

	@Autowired
	CategoryRepository catRepo;

	@Autowired
	ProductSubCategoryRepository subRepo;

	@GetMapping("/getproducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Product> getAllProducts() {
		return productrepo.findAll();
	}

	@GetMapping("/getcategory")
	public Collection<Category> getCategory() {
		return catRepo.findAll();
	}

	@GetMapping("/minAndMax")
	public Object getMinAndMaxPrice() {
		return productrepo.findMinAndMaxPrice();
	}

	@RequestMapping(value = "/getSubFilters", method = RequestMethod.GET)
	public Collection<ProductSubCategory> getSubCategories(@RequestParam("category") Long category) {
		Category cat = catRepo.findById(category).orElse(null);
		return subRepo.findAllByCategory(cat);
	}

	@RequestMapping(path = "/saveproduct", method = RequestMethod.POST)
	public void saveProduct(@RequestBody Product product) {
		ProductSubCategory subCat = subRepo.findById(Long.parseLong(product.getSubType())).orElse(null);
		product.setSubType(subCat.getSubType());
		product.setCategory(subCat.getCategory().getName());
		productrepo.save(product);
	}

	@GetMapping("/product")
	public Product getProduct(@RequestParam("id") Long productId) {
		return productrepo.findById(productId).orElse(null);
	}

}
