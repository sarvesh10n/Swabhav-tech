package constructor.inhertance.test;
import constructor.inheritance.*;

public class TestConstructor {

	public static void main(String args[])
	{
		B b1=new B();
		B b2=new B(100);
		
		System.out.println(b2.getFoo());
	}
}
