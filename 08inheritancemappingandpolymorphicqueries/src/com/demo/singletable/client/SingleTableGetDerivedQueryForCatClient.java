package com.demo.singletable.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.sessionfactory.SessionFactoryUtil;
import com.demo.singletable.entity.Animal;
import com.demo.singletable.entity.Cat;

public class SingleTableGetDerivedQueryForCatClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query cat = session.createQuery("select cat from Cat cat");
			List<Cat> list = cat.getResultList();

			for (Cat cats : list) {
				System.out.println(cats);
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
