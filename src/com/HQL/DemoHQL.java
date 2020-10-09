package com.HQL;

import java.util.Arrays;
import java.util.List;
import com.OneToManyORManyToOne.*;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DemoHQL {

	public static void main(String[] args) {
		Configuration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		
//		for(int i=10;i<=30;i++) {
//			Student_Details sd=new Student_Details();
//			sd.setId(i);
//			sd.setName("Name"+i);
//			sd.setCity("City"+i);
//			session.save(sd);
//		}
		
		//HQL Query and Syntex
		//Single (Unique) and Multiple-List
//		String query="from All_Student";//select Entity name
//		Query q=session.createQuery(query);//create query with help of session and it will return Hibernate Query Object
//		List<Student_Details> list=q.list();//now we have query into List (Studdent_Details Type)
//		
//		for(Student_Details sd:list) {
//			System.out.println(sd.getId()+" : "+sd.getName()+" : "+sd.getCity());
//		}//Traverse our all data from List
		
		//Update Query
//		Query q1=session.createQuery("update All_Student set City='Noida' where Student_ID=16");
//		Query q1=session.createQuery("update All_Student set City=:c where Student_ID=:id");
//		Query q1=session.createQuery("update All_Student as S set S.City=:c where Student_ID=:id");//Dynamic query execution
//		q1.setParameter("c", "South_USA");
//		q1.setParameter("id", "18");
//		int a=q1.executeUpdate();
//		System.out.println("Details Updated: "+a);
		
		//Delete Query
//		Query q2=session.createQuery("delete All_Student where Student_ID=19");
//		Query q2=session.createQuery("delete from All_Student as s where s.City=:c");
//		q2.setParameter("c", "City20");
//		int a1=q2.executeUpdate();
//		System.out.println("Deleted: "+a1);
		
		//Join Query: Inner JOIN
//		Query q3=session.createQuery("select q.question,q.id,a.answer from Question1 as q INNER JOIN q.answers as a");//Alias selection with Inner Join
//		List<Object[]> list3=q3.list();
//		for(Object[] arr:list3) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		//Pagination Using hibernate
//		String query="from All_Student";
//		Query q=session.createQuery(query);
//		q.setFirstResult(0);//set  starting  point
//		q.setMaxResults(10);//set length from starting point
		
//		q.setFirstResult(10);
//		q.setMaxResults(5);
//		
//		List<Student_Details> list4=q.list();
//		for(Student_Details sd:list4) {
//			System.out.println(sd.getId()+" : "+sd.getName()+" : "+sd.getCity());
//		}
		
		//SQLQuery: We can also write our query other than HQL in Hibernate i.e NATIVE Query
//		String q="select * from All_Student_Details";
//		NativeQuery nq=session.createSQLQuery(q);//we have to import native jar for native operation
//		List<Student_Details> list5=nq.list();
//		for(Student_Details sd:list5) {
//			System.out.println(sd.getId()+" : "+sd.getName()+" : "+sd.getCity());
//		}
		
		
		tx.commit();
		session.close();
		factory.close();

	}

}
