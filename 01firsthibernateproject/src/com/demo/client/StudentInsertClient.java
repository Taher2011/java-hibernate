package com.demo.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.demo.entity.Student;
import com.demo.sessionfactory.SessionFactoryUtil;

public class StudentInsertClient {

	public static void main(String[] args) {
		Session session1 = null;
		Session session2 = null;
		try {
			session1 = SessionFactoryUtil.getSessionFactory().openSession();
			session1.beginTransaction();
			
			Student student1 = new Student("Taher", 27, "Indore"); // transient state
			Student student2 = new Student("Taher", 23, "Indore"); // transient state
			
			Set<Student> students = new HashSet<>();
			students.add(student1);
			students.add(student2);

			for (Student student : students) {
				session1.persist(student); // persistent state
				System.out.println("persisted id is " + student.getId());
			}
			
			session1.getTransaction().commit();
			session1.close(); //once session is closed object state became detached
			student1.setCity("Hyderabad"); // detach state
			
			session2 = SessionFactoryUtil.getSessionFactory().openSession();
			session2.beginTransaction();
			session2.merge(student1); // attached the detach state to persistent state
			System.out.println("persisted id is " + student1.getId());
			session2.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session1 != null) {
				session1.close(); //detach state
			}if (session2 != null) {
				session2.close(); //detach state
			}
		}
	}

}
