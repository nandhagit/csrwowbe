package com.wow.wow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.dto.OrderProjection;
import com.wow.wow.model.Orders;
import com.wow.wow.model.WowUser;

@RepositoryRestResource(path = "/orders")
@CrossOrigin(origins = "http://localhost:4200")
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	Orders findByTransactionId(String txnId);

	List<OrderProjection> findByUser(WowUser user);

	List<OrderProjection> findAllProjectedBy();

	OrderProjection getById(Long id);
}