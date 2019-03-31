package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.sessionfactory.SessionFactoryUtil;

public class NonMergeCourseClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Course by primary key id
			Course getCourse = session.get(Course.class, 1);
			System.out.println("Course Infor is " + getCourse);
			System.out.println("Associated Lecturer is " + getCourse.getLecturer());
			session.getTransaction().commit();

			getCourse.setTittle("Angular");
			getCourse.getLecturer().setCity("Surat");
		
			session.beginTransaction();
			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
