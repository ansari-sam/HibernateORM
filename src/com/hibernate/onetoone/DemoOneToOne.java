package com.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoOneToOne {

	public static void main(String[] args) {
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//OnetoOne Uni-Directional Mapping
		System.out.println("OnetoOne Uni-Directional Mapping");
		//creating object of question
		Question q1=new Question();
		q1.setQid(201);
		q1.setQuestion("What is Java");
		
		
		//creating object of Answer
		Answer a1=new Answer();
		a1.setId(101);
		a1.setAnswer("Java is a Programming Language");
		q1.setAnswer(a1);//OnetoOne Uni-Directional Mapping--set ans id to que colomn that is now we call foreign key
		//if we want Bi-Direction mapping in OneToOne Map-then we have to declare ref of quetion in ans class same as per before
		
		//save data into DataBase
		session.save(q1);
		session.save(a1);
	
		tx.commit();
		
		//Fetching data from table
		System.out.println("..............");
		System.out.println("Fetching data from table");
		//Question newQ=(Question)session.load(Question.class, 201);
		Question newQ=(Question)session.get(Question.class, 201);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
		session.close();
	}

}
