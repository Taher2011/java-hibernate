package com.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INSTRUCTOR_SEQ")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CITY")
	private String city;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INST_DET_ID")
	private InstructorDetail instructorDetail;

	public Instructor() {
		super();
	}

	public Instructor(String name, String city, InstructorDetail instructorDetail) {
		super();
		this.name = name;
		this.city = city;
		this.instructorDetail = instructorDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor id=" + id + ", Instructor name=" + name + ", Instructor city=" + city + " and "
				+ instructorDetail;
	}

}
