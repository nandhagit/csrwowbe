package com.wow.wow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wow.wow.entity.Address;
import com.wow.wow.entity.WowUser;

@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByUser(WowUser user);

}
