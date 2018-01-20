package com.techlabs.comparable.comparator.test;
import com.techlabs.student.*;
import java.util.*;

public class ComparableComparatorTest {

	public static void main(String args[])
	{
		 ArrayList<Student> studentList=new ArrayList<Student>();
		 
		 Student stud1=new Student(2,"Sarvesh","Nerurkar","Bhandup");
		 Student stud2=new Student(1,"Atharv","Nerurkar","Bhandup");
		 Student stud3=new Student(3,"xyz","abc","jkl");
		 
		 studentList.add(stud1);
		 studentList.add(stud2);
		 studentList.add(stud3);
		 
		 Collections.sort(studentList,Student.idComparator);
		 
		 System.out.println("After sorting student list is "+studentList);
		 
	}
}
