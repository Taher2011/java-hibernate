package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Employee;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertEmployeeClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Employee employee = new Employee("Sunil");
			session.persist(employee);
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
