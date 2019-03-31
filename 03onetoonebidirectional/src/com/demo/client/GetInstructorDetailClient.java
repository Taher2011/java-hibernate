package com.demo.client;

import org.hibernate.Session;

import com.demo.entity.InstructorDetail;
import com.demo.sessionfactory.SessionFactoryUtil;

public class GetInstructorDetailClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the InstructorDetail by primary key id
			InstructorDetail getInstructorDetail = session.get(InstructorDetail.class, 2);
			if (getInstructorDetail != null) {
				System.out.println("Instructor Infor is " + getInstructorDetail.getInstructor());
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
