package com.aurotech.integration.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CustomerSystem {

	@Id
	Long id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "system_id")
	private System system;

	@OneToMany(mappedBy = "customerSystem")
	private List<CustomerSystemProperty> properties;

	public CustomerSystem(Customer customer, System system) {
		super();
		this.customer = customer;
		this.system = system;
	}

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

	public List<CustomerSystemProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<CustomerSystemProperty> properties) {
		this.properties = properties;
	}

}
