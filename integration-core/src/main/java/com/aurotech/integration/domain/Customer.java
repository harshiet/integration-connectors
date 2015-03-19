package com.aurotech.integration.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	Long id;

	private String name;

	@Column(unique = true)
	private String key;

	public Customer(String name, String key) {
		super();
		this.name = name;
		this.key = key;
	}

	@OneToMany(mappedBy = "customer")
	private List<CustomerSystem> systems = new ArrayList<CustomerSystem>();

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

	public List<CustomerSystem> getSystems() {
		return systems;
	}

	public void addSystem(System s) {
		if (s != null) {
			CustomerSystem cs = new CustomerSystem(this, s);
			systems.add(cs);
		}

	}

}
