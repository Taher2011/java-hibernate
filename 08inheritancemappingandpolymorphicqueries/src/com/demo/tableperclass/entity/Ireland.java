package com.demo.tableperclass.entity;

import javax.persistence.Entity;

@Entity
public class Ireland extends Country {

	@Override
	public String countryName() {
		return "Ireland Irsih";
	}

}
