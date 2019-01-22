package com.wow.wow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.dto.UserProjection;
import com.wow.wow.model.WowUser;

@RepositoryRestResource(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public interface WowUserRepository extends JpaRepository<WowUser, Long> {

	WowUser findByUsername(String userName);

	Optional<UserProjection> findByPhone(Long phonenumber);

	Optional<UserProjection> findByEmail(String email);

	Optional<UserProjection> getById(Long id);
}
