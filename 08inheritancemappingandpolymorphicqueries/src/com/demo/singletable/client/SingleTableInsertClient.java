package com.demo.singletable.client;

import org.hibernate.Session;

import com.demo.sessionfactory.SessionFactoryUtil;
import com.demo.singletable.entity.Cat;
import com.demo.singletable.entity.Dog;

public class SingleTableInsertClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Cat cat = new Cat();
			cat.setName("Lucy");
			Dog dog = new Dog();
			dog.setName("Tiger");
			session.persist(cat);
			session.persist(dog);
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
