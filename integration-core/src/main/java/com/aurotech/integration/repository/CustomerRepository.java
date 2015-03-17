package com.aurotech.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aurotech.integration.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAll();

	Customer findByKey(String key);

}
