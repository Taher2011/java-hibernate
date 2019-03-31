package com.demo.tableperclass.entity;

import javax.persistence.Entity;

@Entity
public class India extends Country {

	@Override
	public String countryName() {
		return "Indian";
	}

}
