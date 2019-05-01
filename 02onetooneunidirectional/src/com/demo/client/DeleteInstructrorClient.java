package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Instructor;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteInstructrorClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the instructor by primary key id
			Instructor getInstructor = session.get(Instructor.class, 2);
			System.out.println("Instructor is " + getInstructor);
			if (getInstructor != null) {
				session.delete(getInstructor);
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
