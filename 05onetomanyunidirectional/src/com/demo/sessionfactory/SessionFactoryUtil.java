package com.demo.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Movie;
import com.demo.entity.Review;

public class SessionFactoryUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Movie.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
