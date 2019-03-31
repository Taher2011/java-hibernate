package com.demo.tableperclass.client;

import org.hibernate.Session;

import com.demo.sessionfactory.SessionFactoryUtil;
import com.demo.tableperclass.entity.India;
import com.demo.tableperclass.entity.Ireland;

public class TableperclassInsertClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			India india = new India();
			india.setName("Madhya");
			Ireland ireland = new Ireland();
			ireland.setName("Dublin");
			session.persist(india);
			session.persist(ireland);
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
