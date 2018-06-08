package com.techlabs.unit.testing;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.assertEquals;

import com.techlabs.college.person.professor.Professor;
import com.techlabs.college.person.student.BRANCH;
import com.techlabs.college.person.student.Student;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
public class UnitTest {

	@Test
	public void checkIfCreatingStudentIsWorkingRight() throws ParseException
	{
		Student student=new Student("Sarvesh","Bhandup",new SimpleDateFormat("mm/dd/yyyy").parse("9/10/1996"),BRANCH.COMPUTER);
	}
	
	@Test
	public void checkGettersOfProfessor() throws ParseException
	{
		Professor professor= new Professor("Sachin", "Thane",new SimpleDateFormat("mm/dd/yyyy").parse("9/10/1996"), 20000);
		System.out.println((double)professor.getBasicSalary());
//		assertEquals((double)20000.0, professor.getBasicSalary());
		assertEquals((int)20000.0,(int)professor.getBasicSalary());
	}
}
	

