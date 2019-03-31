package com.demo.singletable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ANIMAL_SEQ")
	private Long id;

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public abstract String makeNoise();

	@Override
	public String toString() {
		return "Animal name=" + name + ", making noise is " + makeNoise();
	}

}
