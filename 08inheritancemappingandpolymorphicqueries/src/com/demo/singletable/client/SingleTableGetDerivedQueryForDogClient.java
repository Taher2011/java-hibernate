package com.demo.singletable.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.sessionfactory.SessionFactoryUtil;
import com.demo.singletable.entity.Dog;

public class SingleTableGetDerivedQueryForDogClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query dog = session.createQuery("select dog from Dog dog");
			List<Dog> list = dog.getResultList();

			for (Dog dogs : list) {
				System.out.println(dogs);
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
