package com.aurotech.integration.domain;

import org.springframework.data.annotation.Id;

public class CustomerSystemProperties {

	@Id
	private Long id;

	private CustomerSystem customerSystem;

	private String name;
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerSystem getCustomerSystem() {
		return customerSystem;
	}

	public void setCustomerSystem(CustomerSystem customerSystem) {
		this.customerSystem = customerSystem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
