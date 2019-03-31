package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Employee;
import com.demo.entity.Program;
import com.demo.sessionfactory.SessionFactoryUtil;

public class AddProgramsForEmployeeClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Employee getEmployee = session.get(Employee.class, 10);

			Program program1 = new Program("YogaProg");
			Program program2 = new Program("IllnessProg");
			getEmployee.addProgram(program1);
			getEmployee.addProgram(program2);
			session.persist(getEmployee);
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
