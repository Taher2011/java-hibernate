package com.demo.joinedtable.client;

import org.hibernate.Session;

import com.demo.joinedtable.entity.Tcs;
import com.demo.joinedtable.entity.Techm;
import com.demo.sessionfactory.SessionFactoryUtil;

public class JoinedTableInsertClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Tcs tcs = new Tcs();
			tcs.setName("TCS");
			Techm techm = new Techm();
			techm.setName("TechMahindra");
			session.persist(tcs);
			session.persist(techm);
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
