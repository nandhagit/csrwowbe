package com.wow.wow.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.model.Orders;

@RepositoryRestResource(path="/orders")
@CrossOrigin(origins = "http://localhost:4200")
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findByTransactionId(String txnId);
}