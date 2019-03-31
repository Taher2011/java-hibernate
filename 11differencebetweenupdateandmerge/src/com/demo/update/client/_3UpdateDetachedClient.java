package com.demo.update.client;

import org.hibernate.Session;

import com.demo.entity.Student;
import com.demo.sessionfactory.SessionFactoryUtil;

public class _3UpdateDetachedClient {

	public static void main(String[] args) {
		Session session1 = null;
		Session session2 = null;
		try {
			session1 = SessionFactoryUtil.getSessionFactory().openSession();
			session1.beginTransaction();

			Student student1 = session1.get(Student.class, 1);
			System.out.println("persisted id is " + student1.getId());

			session1.getTransaction().commit();
			session1.close(); // once session is closed object state became
								// detached

			student1.setCity("Indore");

			session2 = SessionFactoryUtil.getSessionFactory().openSession();
			session2.beginTransaction();
			Student student2 = session2.get(Student.class, 1);
			session2.update(student1);
			System.out.println("after update, persisted id is " + student1.getId());
			session2.getTransaction().commit();
			session2.close();
		} catch (Exception ex) {
			session2.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			if (session1 != null) {
				session1.close(); // detach state
			}
			if (session2 != null) {
				session2.close(); // detach state
			}

		}
	}

}
