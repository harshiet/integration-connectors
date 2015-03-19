package com.aurotech.integration.repository;

import org.springframework.data.repository.CrudRepository;

import com.aurotech.integration.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByKey(String key);

}
