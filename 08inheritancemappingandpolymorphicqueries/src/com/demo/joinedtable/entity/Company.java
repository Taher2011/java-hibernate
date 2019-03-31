package com.demo.joinedtable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "COMPANY_SEQ")
	private Long id;

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public abstract String domain();

	@Override
	public String toString() {
		return "Company [name=" + name + ", domain=" + domain() + "]";
	}

}
