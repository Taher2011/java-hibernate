package com.demo.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Person;

public class SessionFactoryUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
				.buildSessionFactory();
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
