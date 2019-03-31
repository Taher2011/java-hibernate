package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Review;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetMovieClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Review by primary key id
			Review getReview = session.get(Review.class, 23);
			if (getReview != null) {
				System.out.println("Review Infor is " + getReview);
				System.out.println("Associated Movie is " + getReview.getMovie());
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
