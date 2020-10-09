package com.HibernateLifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoH_Life_Cycle {

	public static void main(String[] args) {
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Transient State: we just create object and set their value of Student 
		Student std=new Student();//(Object still in idle condition--:Not in Session or Database both)
		std.setId(52);
		std.setName("Mohan");
		std.setCity("Delhi");
		
		//Persistent State:if we save the object with the help of session then object goes and save to database
		session.save(std);//object with: Session and Database both
		
		//Removed State:permanently delete from DB and session have student Object(Object is with Session only)
		//session.delete(std);
		
		tx.commit();//Physical change in DB then we have to commit TX
		session.close();
		//Detached State: after Session close, it will permanently save in DB (Object in DB and not connected with Session)
		std.setName("Sachin");//in DB it will show Mohan Only
		System.out.println(std);
		factory.close();

	}

}
