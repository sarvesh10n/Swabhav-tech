package com.techlabs.queue.test;


import com.techlabs.queue.SwabhavQ;
import com.techlabs.student.Student;

public class QueueTest {

	public static void main(String args[])
	{
		SwabhavQ<Student> studentList=new SwabhavQ<Student>();
		
		Student stud1=new Student("Sarvesh", 1);
		Student stud2=new Student("Atharv", 2);
		Student stud3=new Student("Abhishek",3);
		
		studentList.enqueue(stud1);
		studentList.enqueue(stud2);
		studentList.enqueue(stud3);
		
		System.out.println("Count of students are "+studentList.getQueueSize());
		
		Student removedStud1=studentList.dequeue();
		System.out.println("Removed student is "+removedStud1);
		
		System.out.println("Count of students are "+studentList.getQueueSize());
		
		
		for(Student student:studentList)
			System.out.println(student);
	}
}
