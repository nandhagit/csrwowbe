package com.wow.wow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.model.WowUser;

@RepositoryRestResource(path="/users")
@CrossOrigin(origins = "http://localhost:4200")
public interface WowUserRepository extends JpaRepository<WowUser, Long>{
	Optional<WowUser> findByEmail(String email);
	WowUser findByUsername(String userName);
}
