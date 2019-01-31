package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.Authority;

@RepositoryRestResource(path = "authority")
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
