package com.demo.tableperclass.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.joinedtable.entity.Techm;
import com.demo.sessionfactory.SessionFactoryUtil;

public class JoinedTableGetDerivedQueryForTechmClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query techm = session.createQuery("select techm from Techm techm");
			List<Techm> list = techm.getResultList();

			for (Techm techms : list) {
				System.out.println(techms);
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
