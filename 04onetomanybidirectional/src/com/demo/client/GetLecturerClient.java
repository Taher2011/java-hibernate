package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Lecturer;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetLecturerClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the Lecturer by primary key id
			Lecturer getLecturer = session.get(Lecturer.class, 1);
			if (getLecturer != null) {
				System.out.println("Lecturer Infor is " + getLecturer);
				session.getTransaction().commit();
				System.out.println("Associated Courses are " + getLecturer.getCourses());
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
