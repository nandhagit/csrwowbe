package com.wow.wow.serviceimpl;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wow.wow.dto.ProductDTO;
import com.wow.wow.entity.Category;
import com.wow.wow.entity.Product;
import com.wow.wow.entity.ProductHistory;
import com.wow.wow.entity.ProductSubCategory;
import com.wow.wow.repository.CategoryRepository;
import com.wow.wow.repository.ProductHistoryRepository;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.ProductSubCategoryRepository;
import com.wow.wow.service.ProductService;
import com.wow.wow.utility.UserUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productrepo;

	@Autowired
	ProductHistoryRepository productHistoryRepo;

	@Autowired
	CategoryRepository catRepo;

	@Autowired
	ProductSubCategoryRepository subRepo;

	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	UserUtil userUtil;

	public Collection<ProductDTO> getAllProducts() {
		ModelMapper mapper = new ModelMapper();
		return productrepo.findAll().stream().map(product -> mapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	public Collection<Category> getCategory() {
		return catRepo.findAll();
	}

	public Object getMinAndMaxPrice() {
		return productrepo.findMinAndMaxPrice();
	}

	public Collection<ProductSubCategory> getSubCategories(Long category) {
		Category cat = catRepo.findById(category).orElse(null);
		return subRepo.findAllByCategory(cat);
	}

	public void saveProduct(Product product) {
		ProductSubCategory subCat = subRepo.findById(Long.parseLong(product.getSubType())).orElse(null);
		product.setSubType(subCat.getSubType());
		product.setCategory(subCat.getCategory().getName());
		product.setCreatedDate(new Date());
		product.setLastModifiedDate(new Date());
		product.setCreatedBy(userUtil.getUser());
		product.setCode(generateUniqueProductCode(product.getCategory()));
		ProductHistory productHistory = mapper.map(product, ProductHistory.class);
		productrepo.save(product);
		productHistory.setProductId(product);
		productHistory.setModifiedBy(userUtil.getUser());
		productHistoryRepo.save(productHistory);
	}

	public void updateProduct(Product product) {
		ProductSubCategory subCat = subRepo.findById(Long.parseLong(product.getSubType())).orElse(null);
		product.setSubType(subCat.getSubType());
		product.setCategory(subCat.getCategory().getName());
		product.setLastModifiedDate(new Date());
		ProductHistory productHistory = mapper.map(product, ProductHistory.class);
		productHistory.setId(null);
		productrepo.save(product);
		productHistory.setProductId(product);
		productHistory.setModifiedBy(userUtil.getUser());
		productHistoryRepo.save(productHistory);
	}

	public Product getProduct(Long productId) {
		return productrepo.findById(productId).orElse(null);
	}
	
	
	
	private String generateUniqueProductCode(String category) {
		return "WOW"+category.toUpperCase()+String.format("%07d", productrepo.findLatestId());
		
	}

}