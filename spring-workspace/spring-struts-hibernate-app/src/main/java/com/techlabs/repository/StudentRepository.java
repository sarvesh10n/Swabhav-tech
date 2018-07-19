package com.techlabs.repository;

import com.techlabs.entity.Student;

import java.util.ArrayList;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	ArrayList<Student> studentList = new ArrayList<>();

	public StudentRepository() {
		System.out.println("Student repository created");
	}

	public ArrayList<Student> get() {
		// addStudent();
		try {

			session = factory.openSession();
			txn = session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			studentList = (ArrayList<Student>) criteria.list();
			txn.commit();
			System.out.println("data displayed");
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		}
		finally{
			session.close();
		}
		return studentList;
	}

	public void addStudent(Student student) {
		studentList.add(student);

		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(student);
			txn.commit();
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		
	}

	public Student getStudentForUpdate(int rollNo) {
		Student student=null;
		try{
			session=factory.openSession();
			txn=session.beginTransaction();
			student=(Student) session.get(Student.class, rollNo);
			System.out.println("succesfully student fetched");
		}
		catch(HibernateException e){
			System.out.println(e);
			txn.rollback();
		}
		finally{
			session.close();
		}
		System.out.println(student.getFirstName());
		return student;
	}

	public void updateStudent(int rollNo, Student student) {
		Student tempStudent=null;
		try{
			session=factory.openSession();
			txn=session.beginTransaction();
			tempStudent=(Student) session.get(Student.class, rollNo);
			tempStudent.setFirstName(student.getFirstName());
			tempStudent.setLastName(student.getLastName());
			tempStudent.setAddress(student.getAddress());
			session.save(tempStudent);
			txn.commit();
			
		}
		catch(HibernateException e){
			System.out.println(e);
			txn.rollback();
		}
		finally{
			session.close();
		}
		System.out.println(student.getFirstName());
	}
	
	public void deleteStudent(int rollNo){
		try{
			session=factory.openSession();
			txn=session.beginTransaction();
			Student s=(Student) session.get(Student.class, rollNo);
			session.delete(s);
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
