package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Movie;
import com.demo.entity.Review;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertMovieClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Movie movie = new Movie("Amazon");
			movie.addReview(new Review("Good", movie));
			movie.addReview(new Review("Excellent", movie));
			session.persist(movie);
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
