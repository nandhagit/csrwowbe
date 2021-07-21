package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.Rating;

@RepositoryRestResource(path = "rating")
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
