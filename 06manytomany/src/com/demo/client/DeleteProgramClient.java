package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Program;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteProgramClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Program by primary key id
			Program getProgram = session.get(Program.class, 4);
			if (getProgram != null) {
				System.out.println("getProgram is " + getProgram);
				session.delete(getProgram);
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
