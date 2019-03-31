package com.demo.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.joinedtable.entity.Company;
import com.demo.joinedtable.entity.Tcs;
import com.demo.joinedtable.entity.Techm;
import com.demo.singletable.entity.Animal;
import com.demo.singletable.entity.Cat;
import com.demo.singletable.entity.Dog;
import com.demo.tableperclass.entity.Country;
import com.demo.tableperclass.entity.India;
import com.demo.tableperclass.entity.Ireland;

public class SessionFactoryUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Animal.class)
				.addAnnotatedClass(Cat.class).addAnnotatedClass(Dog.class).addAnnotatedClass(Company.class)
				.addAnnotatedClass(Tcs.class).addAnnotatedClass(Techm.class).addAnnotatedClass(Country.class)
				.addAnnotatedClass(India.class).addAnnotatedClass(Ireland.class).buildSessionFactory();
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
