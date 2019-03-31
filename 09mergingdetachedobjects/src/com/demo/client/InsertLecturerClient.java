package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.entity.Lecturer;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertLecturerClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Lecturer lecturer = new Lecturer("Samar", "Mumbai");
			Course course1 = new Course("No-SQL", lecturer);
			Course course2 = new Course("Hadoop", lecturer);
			lecturer.addCourse(course1);
			lecturer.addCourse(course2);
			session.persist(lecturer);
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
