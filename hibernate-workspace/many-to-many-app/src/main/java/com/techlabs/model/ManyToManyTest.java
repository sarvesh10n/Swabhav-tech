package com.techlabs.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyTest {
	
	static Session session=null;
	static Transaction txn=null;
	
	public static void main(String args[]){
		
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory factory=config.buildSessionFactory();
		
		System.out.println(factory.getClass());
		
		try{
			session=factory.openSession();
			txn=session.beginTransaction();
			
			Actor actor1=new Actor();
			actor1.setName("Shahid kapoor");
			
			Actor actor2=new Actor();
			actor2.setName("Amir khan");
			
			Actor actor3=new Actor();
			actor3.setName("Alia bhatt");
			
			Movie movie1=new Movie();
			movie1.setName("Dangal");
			movie1.getActorList().add(actor2);
			
			actor2.getMovieList().add(movie1);
			
			Movie movie2=new Movie();
			movie2.setName("Shaandar");
			movie2.getActorList().add(actor1);
			movie2.getActorList().add(actor3);
			
			actor1.getMovieList().add(movie2);	
			actor3.getMovieList().add(movie2);
			
			session.save(movie1);
			session.save(movie2);
			txn.commit();
			
		}
		catch(HibernateException e){
			System.out.println(e);
			txn.rollback();
		}
		finally{
			session.close();
		}
	}
}
