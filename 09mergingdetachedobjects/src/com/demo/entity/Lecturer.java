package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "LECTURER")
public class Lecturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LECTURER_SEQ")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CITY")
	private String city;

	@Version
	private Integer version;

	@OneToMany(mappedBy = "lecturer", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<Course> courses = new ArrayList<>();

	public Lecturer() {
		super();
	}

	public Lecturer(String name, String city) {
		super();
		this.name = name;
		this.city = city;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void addCourse(Course course) {
		courses.add(course);
		course.setLecturer(this);
	}

	@Override
	public String toString() {
		return "LecturerDetail [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

}
