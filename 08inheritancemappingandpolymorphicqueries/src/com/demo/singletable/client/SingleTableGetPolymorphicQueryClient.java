package com.demo.singletable.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.sessionfactory.SessionFactoryUtil;
import com.demo.singletable.entity.Animal;

public class SingleTableGetPolymorphicQueryClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query animal = session.createQuery("select animal from Animal animal");
			List<Animal> list = animal.getResultList();

			for (Animal animals : list) {
				System.out.println(animals);
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
