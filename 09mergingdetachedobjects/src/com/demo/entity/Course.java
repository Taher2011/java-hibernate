package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "COURSE_SEQ")
	private int id;

	@Column(name = "TITTLE")
	private String tittle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LECTURER_ID")
	private Lecturer lecturer;

	public Course() {
		super();
	}

	public Course(String tittle, Lecturer lecturer) {
		super();
		this.tittle = tittle;
		this.lecturer = lecturer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	@Override
	public String toString() {
		return "Course id=" + id + ", Course tittle=" + tittle;
	}

}
