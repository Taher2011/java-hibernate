package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSTRUCTOR_DETAIL")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INSTRUCTOR_DETAIL_SEQ")
	private int id;

	@Column(name = "HOBBY")
	private String hobby;

	@Column(name = "CHANNEL")
	private String channel;

	public InstructorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstructorDetail(String hobby, String channel) {
		super();
		this.hobby = hobby;
		this.channel = channel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", hobby=" + hobby + ", channel=" + channel + "]";
	}

}
