package com.demo.tableperclass.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "hibernate_sequences")
	private Long id;

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public abstract String countryName();

	@Override
	public String toString() {
		return "Country name=" + name + ", countryName is " + countryName();
	}

}
