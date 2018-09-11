package com.wow.wow.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wow.wow.model.Payment;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Payment findByTxnId(String txnId);
}