package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Movie;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteMovieClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Movie by primary key id
			Movie getMovie = session.get(Movie.class, 16);
			if (getMovie != null) {
				System.out.println("getMovie is " + getMovie);
				//Below commented  code is for if we dont want to delete associated reviews
				/*for (Review review : getMovie.getReviews()) {
					review.setMovie(null);
				}*/
				session.delete(getMovie);
			} else {
				System.out.println("No Record Found");
			}
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
