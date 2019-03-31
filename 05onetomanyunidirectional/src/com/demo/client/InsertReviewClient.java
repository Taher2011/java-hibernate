package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Movie;
import com.demo.entity.Review;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertReviewClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Movie movie = new Movie("NetFlix");
			Review review1 = new Review("Nice", movie);
			Review review2 = new Review("OK", movie);
			movie.addReview(review1);
			movie.addReview(review2);
			session.persist(review1);
			session.persist(review2);
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
