package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Program;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetProgramAndItsEmployeeClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Program getProgAndItsEmp = session.get(Program.class, 5);

			if (getProgAndItsEmp != null) {
				System.out.println("Program details is " + getProgAndItsEmp);
				System.out.println("Associated Employees are " + getProgAndItsEmp.getEmployees());
			} else {
				System.out.println("No record found");
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
