package com.techlabs.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techlabs.service.StudentService;

public class TestDI {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		StudentService studentService1 = context.getBean("studentSvc",
				StudentService.class);

		System.out.println(studentService1.hashCode());
		System.out.println(studentService1.getStudentList().size());

		StudentService studentService2 = context.getBean("studentSvc",
				StudentService.class);
		System.out.println(studentService2.hashCode());
		System.out.println(studentService2.getStudentList().size());

	}

}
