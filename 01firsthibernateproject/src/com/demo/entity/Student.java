package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "STUDENT_SEQ")
	private int id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "ROLL_NO")
	private int rollNo;

	@Column(name = "CITY")
	private String city;

	public Student() {
	}

	public Student(String firstName, int rollNo, String city) {
		super();
		this.firstName = firstName;
		this.rollNo = rollNo;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", roll=" + rollNo + ", city=" + city + "]";
	}

	public int hashCode() {
		return rollNo + 10;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		Student student = (Student) object;
		if (student.getRollNo() == this.rollNo) {
			return true;
		}
		return false;
	}

}