package com.demo.joinedtable.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.joinedtable.entity.Company;
import com.demo.sessionfactory.SessionFactoryUtil;

public class JoinedTableGetPolymorphicQueryClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query company = session.createQuery("select company from Company company");
			List<Company> list = company.getResultList();

			for (Company companys : list) {
				System.out.println(companys);
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
