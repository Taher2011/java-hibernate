package com.demo.save.client;

import org.hibernate.Session;

import com.demo.entity.Student;
import com.demo.sessionfactory.SessionFactoryUtil;

public class _3SaveDetahedClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Student student = new Student("Taher", 27, "Indore"); // transient state

			Integer idt = (Integer) session.save(student); // persistent state
			System.out.println("saved id is " + idt);
			System.out.println("saved id is " + student.getId());

			session.getTransaction().commit();
			session.close(); // once session is closed object state became detached

			student.setCity("Mumbai");

			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Integer idp = (Integer) session.save(student);  // persisting detached object won't
															// throw an exception, but
															// insert new row
															// and assigns it a new identifier
			System.out.println("saved id is " + idp);
			session.getTransaction().commit();
			session.close();
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
