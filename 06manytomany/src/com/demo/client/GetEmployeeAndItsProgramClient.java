package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Employee;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetEmployeeAndItsProgramClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Employee getEmpAndItsProg = session.get(Employee.class, 3);

			if (getEmpAndItsProg != null) {
				System.out.println("Employee details is " + getEmpAndItsProg);
				System.out.println("Associated  Programs are " + getEmpAndItsProg.getPrograms());
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
