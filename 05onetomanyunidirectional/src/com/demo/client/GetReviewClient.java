package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Movie;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetReviewClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Movie by primary key id
			Movie getMovie = session.get(Movie.class, 13);
			if (getMovie != null) {
				System.out.println("getMovie Infor is " + getMovie);
				System.out.println("Associated Review are " + getMovie.getReviews());
				session.getTransaction().commit();
			} else {
				System.out.println("No Record Found");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
