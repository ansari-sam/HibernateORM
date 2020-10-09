package com.OneToManyORManyToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoCaching {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//Hibernate Caching: Having two Type of caching
		//1.First level:By Default Provided: Help of::: Session Object
		//2.Second Level:Manually Enable: Help Of:::    SessionFactory
		
		//By Default enable
		Question q1=(Question) s.get(Question.class, 13);
		System.out.println(q1.getQuestion());
		for(Answer a:q1.getAnswers()) {
			System.out.println(a.getAnswer());
}
		
		System.out.println("Working Something.......");
		Question q2=(Question) s.get(Question.class, 13);
		System.out.println(q2.getQuestion());
		
		
		for(Answer a:q2.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		
		System.out.println(s.contains(q2));
		
		
		tx.commit();
		s.close();
		factory.close();

	}

}
