package com.aurotech.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class System {

	@Id
	private Long id;

	@Column(unique = true)
	private String name;

	@Column(unique = true)
	private String key;

	public System(String name, String key) {
		super();
		this.name = name;
		this.key = key;
	}

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
