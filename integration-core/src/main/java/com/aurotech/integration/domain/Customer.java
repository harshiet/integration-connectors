package com.aurotech.integration.domain;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	private Long id;

	private String name;

	private String key;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}