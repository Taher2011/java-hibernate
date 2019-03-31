package com.demo.joinedtable.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.joinedtable.entity.Tcs;
import com.demo.sessionfactory.SessionFactoryUtil;

public class JoinedTableGetDerivedQueryForTcsClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query tcs = session.createQuery("select tcs from Tcs tcs");
			List<Tcs> list = tcs.getResultList();

			for (Tcs tcss : list) {
				System.out.println(tcss);
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
