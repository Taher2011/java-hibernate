package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Review;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteReviewClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Review by primary key id
			Review getReview = session.get(Review.class, 29);
			if (getReview != null) {
				System.out.println("getMovie is " + getReview);
				session.delete(getReview);
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
