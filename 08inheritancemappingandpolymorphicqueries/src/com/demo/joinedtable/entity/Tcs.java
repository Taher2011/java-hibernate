package com.demo.joinedtable.entity;

import javax.persistence.Entity;

@Entity
public class Tcs extends Company {

	@Override
	public String domain() {
		return "Java";
	}

}
