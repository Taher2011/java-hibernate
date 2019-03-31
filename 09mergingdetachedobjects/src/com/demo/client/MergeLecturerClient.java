package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.entity.Lecturer;
import com.demo.sessionfactory.SessionFactoryUtil;

public class MergeLecturerClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Lecturer by primary key id
			Lecturer getLecturer = session.get(Lecturer.class, 1);
			System.out.println("Lecturer Infor is " + getLecturer);
			Course courseUpdated = null;
			for (Course course : getLecturer.getCourses()) {
				if (course.getId() == 1) {
					courseUpdated = course;
				}
			}
			session.getTransaction().commit();
			session.close();

			getLecturer.setCity("Kolkata");
			courseUpdated.setTittle("Yes SQL");

			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.merge(getLecturer);
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
