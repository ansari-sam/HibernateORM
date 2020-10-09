package com.OneToManyORManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoLazyEager {

	public static void main(String[] args) {
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Eager Loading--:loading all query at the time of question id invocation
		Question q=(Question)session.get(Question.class, 12);
		System.out.println(q.getId()+" : " +q.getQuestion());
		for(Answer a:q.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		System.out.println(q.getAnswers().size());
		
		//Lazy Loading--:loading only as per given task
//		Question q=(Question)session.get(Question.class, 12);
//		System.out.println(q.getId()+" : " +q.getQuestion());
//		System.out.println(q.getAnswers().size());
//		for(Answer a:q.getAnswers()) {
//		System.out.println(a.getAnswer());
//		}
		
		tx.commit();
		session.close();
		factory.close();

	}

}
