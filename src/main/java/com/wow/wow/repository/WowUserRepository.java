package com.wow.wow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.WowUser;

@RepositoryRestResource(path = "/users")
public interface WowUserRepository extends JpaRepository<WowUser, Long> {

	WowUser findByUsername(String userName);

	Optional<WowUser> findByPhone(Long phonenumber);

	Optional<WowUser> findByEmail(String email);

}
