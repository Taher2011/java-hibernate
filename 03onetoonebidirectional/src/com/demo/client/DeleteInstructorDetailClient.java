package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Instructor;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteInstructorDetailClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the InstructorDetail by primary key id
			Instructor getInstructor = session.get(Instructor.class, 3);
			if (getInstructor != null) {
				System.out.println("Instructor is " + getInstructor);
				getInstructor.setInstructorDetail(null);
				session.delete(getInstructor);
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
