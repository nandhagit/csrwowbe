package com.wow.wow.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.wow.wow.entity.Category;
import com.wow.wow.entity.ProductSubCategory;
import com.wow.wow.repository.CategoryRepository;
import com.wow.wow.repository.ProductSubCategoryRepository;
import com.wow.wow.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository catRepo;

	@Autowired
	ProductSubCategoryRepository subRepo;

	public Collection<Category> getCategory() {
		return catRepo.findAll();
	}

	public Collection<ProductSubCategory> getSubCategories(@RequestParam("category") Long category) {
		Category cat = catRepo.findById(category).orElse(null);
		return subRepo.findAllByCategory(cat);
	}

}
