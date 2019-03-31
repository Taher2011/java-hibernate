package com.demo.joinedtable.entity;

import javax.persistence.Entity;

@Entity
public class Techm extends Company {

	@Override
	public String domain() {
		return "Oracle";
	}

}
