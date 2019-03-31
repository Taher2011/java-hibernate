package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Employee;
import com.demo.entity.Program;
import com.demo.sessionfactory.SessionFactoryUtil;

public class AddEmployeesForProgramClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Program getProgram = session.get(Program.class, 5);

			Employee employee1 = new Employee("Atul");
			Employee employee2 = new Employee("Ajay");
			Employee employee3 = new Employee("Anil");
			getProgram.addEmployee(employee1);
			getProgram.addEmployee(employee2);
			getProgram.addEmployee(employee3);
			session.persist(getProgram);
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
