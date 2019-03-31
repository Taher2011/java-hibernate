package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.sessionfactory.SessionFactoryUtil;

public class InsertInstructrorClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			InstructorDetail instructorDetail = new InstructorDetail("Coding", "Gmail");
			Instructor instructor = new Instructor("Taher", "Indore", instructorDetail);
			session.persist(instructor);
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
