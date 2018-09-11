package com.wow.wow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.model.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>{

}
