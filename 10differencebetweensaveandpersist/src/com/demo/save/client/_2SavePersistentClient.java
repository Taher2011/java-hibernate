package com.demo.save.client;

import org.hibernate.Session;

import com.demo.entity.Student;
import com.demo.sessionfactory.SessionFactoryUtil;

public class _2SavePersistentClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Student student = new Student("Taher", 27, "Indore"); // transient
																	// state

			Integer idt1 = (Integer)session.save(student); // persistent state
			System.out.println("saved id is " + idt1);

			student.setCity("Mumbai");
			Integer idt2 = (Integer)session.save(student); // persistent state
			System.out.println("saved id is " + idt2);
			
			session.getTransaction().commit();
			session.close(); // once session is closed object state became
								// detached

			

		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); // detach state
			}
		}
	}

}
