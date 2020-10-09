package com.OneToManyORManyToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoCascading {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//Cascading in Hibernate
		Question q=new Question(); 
		q.setId(501);
		q.setQuestion("What is Cascading?");
		
		Answer a1=new Answer(221,"In hibernate it is important concept",q);
		Answer a2=new Answer(231,"we just save only question object then it will save automaticaly the answer list",q);
		Answer a3=new Answer(232,"cascading present in Hibernate framework",q);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q.setAnswers(list);
		//without using cascadding
//		s.save(q);
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
		
		//Using Cascading: we have to just write [cascade=CascadeType.ALL] in our given properties[private List<Answer> answers;] which are in Question Class 
		//Now we just save our question object then answer automatic will save in database {we can apply any operations i.e update,delete,select}
		s.save(q);
		
		tx.commit();
		s.close();
		factory.close();
		

	}

}
