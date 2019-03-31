package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Course;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetCourseClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Course by primary key id
			Course getCourse = session.get(Course.class, 5);
			if (getCourse != null) {
				System.out.println("Lecturer Infor is " + getCourse);
				session.getTransaction().commit();
			} else {
				System.out.println("No Record Found");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
