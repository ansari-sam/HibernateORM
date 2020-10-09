package com.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoManyToMany {

	public static void main(String[] args) {
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Creating object of Emp
		Emp e1=new Emp();
		e1.setEid(31);
		e1.setEname("Ram");
		Emp e2=new Emp();
		e2.setEid(32);
		e2.setEname("Shyam");
		Emp e3=new Emp();
		e3.setEid(33);
		e3.setEname("Sunder");
		
		//Creating object of Project
		Project p1=new Project();
		p1.setPid(41);
		p1.setPname("Library Management");
		Project p2=new Project();
		p2.setPid(42);
		p2.setPname("ChatBot");
		Project p3=new Project();
		p3.setPid(43);
		p3.setPname("Ecommerce Website");
		Project p4=new Project();
		p4.setPid(44);
		p4.setPname("School Management");
		Project p5=new Project();
		p5.setPid(45);
		p5.setPname("Online Booking");
		
		//Creating list of project or emp
		List<Emp> list1=new ArrayList<Emp>();
		list1.add(e1);
		list1.add(e2);
		p1.setEmps(list1);
		List<Emp> list2=new ArrayList<Emp>();
		list2.add(e3);
		list2.add(e1);
		p2.setEmps(list2);
		List<Emp> list3=new ArrayList<Emp>();
		list3.add(e2);
		list3.add(e3);
		p3.setEmps(list3);
		
		List<Project> list4=new ArrayList<Project>();
		list4.add(p1);
		list4.add(p2);
		e1.setProjects(list4);
		List<Project> list5=new ArrayList<Project>();
		list5.add(p3);
		list5.add(p2);
		list5.add(p1);
		e2.setProjects(list5);
		
		List<Project> list6=new ArrayList<Project>();
		list6.add(p4);
		list6.add(p5);
		e3.setProjects(list6);
		
		//Save data to Database
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
