package com.aurotech.integration.domain;

import org.springframework.data.annotation.Id;

public class CustomerSystem {

	@Id
	private Long id;
	private Customer customer;
	private System system;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
}
