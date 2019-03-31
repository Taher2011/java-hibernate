package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MOVIE_SEQ")
	private int id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MOVIE_ID")
	private List<Review> reviews = new ArrayList<>();

	public Movie() {
		super();
	}

	public Movie(String name) {
		super();
		this.name = name;
	}

	public Movie(String name, List<Review> reviews) {
		super();
		this.name = name;
		this.reviews = reviews;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public String toString() {
		return "Movie id=" + id + ", Movie tittle=" + name;
	}

}
