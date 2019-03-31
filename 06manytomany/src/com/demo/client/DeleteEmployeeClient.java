package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Employee;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteEmployeeClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Employee by primary key id
			Employee getEmployee = session.get(Employee.class, 10);
			if (getEmployee != null) {
				System.out.println("getProgram is " + getEmployee);
				session.delete(getEmployee);
			} else {
				System.out.println("No Record Found");
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
