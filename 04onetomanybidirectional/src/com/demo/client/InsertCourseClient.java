package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.entity.Lecturer;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertCourseClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Lecturer lecturer = new Lecturer("Sumeet", "Mumbai");
			Course course1 = new Course("OracleApps", lecturer);
			Course course2 = new Course("SOAP-WS", lecturer);
			lecturer.addCourse(course1);
			lecturer.addCourse(course2);
			session.persist(course1);
			session.persist(course2);
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
