package com.OneToManyORManyToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoOneToMany {

	public static void main(String[] args) {
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Creating object of Question
		Question q1=new Question();
		q1.setId(12);
		q1.setQuestion("What is Java Language");
		
		Question q2=new Question();
		q2.setId(13);
		q2.setQuestion("What is Python");
		
		//Creating object of Answer
		Answer ans1=new Answer();
		ans1.setId(20);
		ans1.setAnswer("Java is a High-Level prog Language");
		ans1.setQuestion(q1);
		
		Answer ans2=new Answer();
		ans2.setId(21);
		ans2.setAnswer("Java has different framework which are using world-wide");
		ans2.setQuestion(q1);
		
		Answer ans3=new Answer();
		ans3.setId(22);
		ans3.setAnswer("Java is most powerfull language and having used by mostly 50%");
		ans3.setQuestion(q1);
		
		Answer ans4=new Answer();
		ans4.setId(23);
		ans4.setAnswer("Python has MI and AI");
		ans4.setQuestion(q2);
		
		Answer ans5=new Answer();
		ans5.setId(24);
		ans5.setAnswer("Python is now using mostly to developing robotic Technology");
		ans5.setQuestion(q2);
		
		//creating list of answers
		List<Answer> list1=new ArrayList<Answer>();
		List<Answer> list2=new ArrayList<Answer>();
		
		//Set answer for q1
		list1.add(ans1);
		list1.add(ans2);
		list1.add(ans3);
		q1.setAnswers(list1);
		
		//Set answer for q2
		list2.add(ans4);
		list2.add(ans5);
		q2.setAnswers(list2);
		
		//saving data into database using session 
		session.save(q1);
		session.save(q2);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		session.save(ans4);
		session.save(ans5);
		
		tx.commit();
		session.close();
		factory.close();
		

	}

}
