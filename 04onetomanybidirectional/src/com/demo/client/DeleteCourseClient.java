package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.sessionfactory.SessionFactoryUtil;

public class DeleteCourseClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Course by primary key id
			Course getCourse = session.get(Course.class, 1);
			if (getCourse != null) {
				System.out.println("Instructor is " + getCourse);
				session.delete(getCourse);
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
