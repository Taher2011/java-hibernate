package com.demo.singletable.entity;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

	@Override
	public String makeNoise() {
		return "Bark";
	}

}
