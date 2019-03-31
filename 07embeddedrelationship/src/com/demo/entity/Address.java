package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIPCODE")
	private String zipcode;

	public Address() {
	}

	public Address(String street, String city, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return " street=" + street + ", city=" + city + ", zipcode=" + zipcode;
	}

}