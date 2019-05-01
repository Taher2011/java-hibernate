package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.entity.Lecturer;
import com.demo.sessionfactory.SessionFactoryUtil;

public class UpdateLectureClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Lecturer by primary key id
			Lecturer getLecturer = session.get(Lecturer.class, 1);
			Course getCourse = session.get(Course.class, 1);
			if (getLecturer != null) {
				System.out.println("Instructor is " + getLecturer);
				System.out.println("Course is " + getCourse);
				getCourse.setLecturer(getLecturer);
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
