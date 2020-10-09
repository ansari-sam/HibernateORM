package com.hibernate.anotationbasic;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		System.out.println("project Started");
		
		//Configuration cfg= new Configuration();
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Creating obj of frnd class and set their instance properties values by setter method
		Friend frnd=new Friend();
		frnd.setName("Aman Jha");
		frnd.setEmail("Aman7210624@gmail.com");
		frnd.setBranch("B.Tech_2014");
		frnd.setWhatsapp_No("8882999275");
		
//		System.out.println("................");
//		System.out.println(frnd);
		
		System.out.println("................");
		//Creating obj of frndAddress class and set their instance properties values by setter method
		FrndAddress frndads=new FrndAddress();
		frndads.setStreet("Faridabaad");
		frndads.setCity("Faridabaad Metro");
		frndads.setState("Haryana");
		frndads.setAddedDate(new Date());
		
		frnd.setFrndAds(frndads);
//		System.out.println(frndads);
		System.out.println("................");
		//save obj to the databases with SAVE method help of session obj
		session.save(frnd);
		//session.save(frndads);
		
		//Fetching data from database
		//Friend friend=(Friend)session.get(Friend.class, 1);
		Friend friend=(Friend)session.load(Friend.class, 1);
		System.out.println(friend);
	
		tx.commit();
		session.close();
//		System.out.println(factory);
//		System.out.println(factory.isClosed());

	}

}
