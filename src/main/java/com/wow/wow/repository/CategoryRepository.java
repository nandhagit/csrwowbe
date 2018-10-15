package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.model.Category;

@RepositoryRestResource(path="/category")
@CrossOrigin(origins = "http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
