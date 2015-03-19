package com.aurotech.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurotech.integration.domain.Customer;
import com.aurotech.integration.domain.System;
import com.aurotech.integration.repository.CustomerRepository;

@SpringBootApplication
public class JiraConnectorApp {

	@Autowired
	private CustomerRepository customerRepository;

	public JiraConnectorApp() {
		Customer c = new Customer("Pepsi Co.", "PEPSI");
		System s = new System("JIRA", "JIRA");
		c.addSystem(s);
		customerRepository.save(c);
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(JiraConnectorApp.class, args);
	}
}
