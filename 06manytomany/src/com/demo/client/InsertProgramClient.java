package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Employee;
import com.demo.entity.Program;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertProgramClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Program program = new Program("Admin Prog");
			session.persist(program);
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
