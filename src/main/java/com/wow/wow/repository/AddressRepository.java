package com.wow.wow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.dto.AddressProjection;
import com.wow.wow.model.Address;
import com.wow.wow.model.WowUser;

@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<AddressProjection> findByUser(WowUser user);

}
