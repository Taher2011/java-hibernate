package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Person;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetPersonClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Person person = session.get(Person.class, 1);
			if (person != null) {
				System.out.println("Person is " + person);
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
