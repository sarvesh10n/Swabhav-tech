package com.techlabs.student.test;
import com.techlabs.student.*;
import java.util.*;

public class TestSetRepeat {

	public static void main(String args[])
	{
		HashSet<Student> studentSet=new HashSet<Student>();
		
		Student stud1=new Student("Sarvesh","Nerurkar","Bhandup");
		Student stud2=new Student("Sarvesh","Nerurkar","Bhandup");
		
		
		studentSet.add(stud1);
		studentSet.add(stud2);
		
		System.out.println(studentSet);

	}
}
