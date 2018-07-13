package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techlabs.department.Department;
import com.techlabs.employee.Employee;

public class MantToOneTest {
	static Transaction txn = null;
	static Session session = null;

	public static void main(String args[]) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();
		System.out.println(factory.getClass());
		
		try{
			session = factory.openSession();
			txn = session.beginTransaction();
			
			Department dept=new Department();
			dept.setName("comps");
			
			Set<Employee>emps=new HashSet<>();
			
			Employee emp=new Employee();
			emp.setDept(dept);
			emp.setName("sarvesh");
			
			Employee emp1=new Employee();
			emp1.setDept(dept);
			emp1.setName("abhishek");
			
			emps.add(emp);
			emps.add(emp1);

			dept.setEmployee(emps);
			session.save(dept);
			txn.commit();
		}
		catch(HibernateException e){
			System.out.println(e);
			txn.rollback();
		}
	}
}
