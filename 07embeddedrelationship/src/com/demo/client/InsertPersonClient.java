package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Address;
import com.demo.entity.Person;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertPersonClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Address address = new Address("SaifeeNagar", "Indore", "452001");
			Person person = new Person("Taher", address);
			session.persist(person);
			System.out.println("persisted id is " + person.getId());
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
