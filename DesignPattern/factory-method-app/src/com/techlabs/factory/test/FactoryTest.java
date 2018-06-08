package com.techlabs.factory.test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.techlabs.factory.AudiFactory;
import com.techlabs.factory.BmwFactory;
import com.techlabs.factory.TeslaFactory;
import com.techlabs.interfaces.IAutoFactory;
import com.techlabs.interfaces.IAutoMobile;

public class FactoryTest {

	public static void main(String args[]) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		IAutoFactory auto1 =AudiFactory.getInstance();
		IAutoMobile autoMobile1=auto1.make();
		autoMobile1.start();
		autoMobile1.stop();
		
		IAutoFactory auto2 = BmwFactory.getInstance();
		IAutoMobile autoMobile2=auto2.make();
		autoMobile2.start();
		autoMobile2.stop();
		
		IAutoFactory auto3 = TeslaFactory.getInstance();
		IAutoMobile autoMobile3=auto3.make();
		autoMobile3.start();
		autoMobile3.stop();
		
		System.out.println("\nUsing property file");
		IAutoFactory factory=createFactoryFromPropertyFile();
		IAutoMobile autoMobile4=factory.make();
		autoMobile4.start();
		autoMobile4.stop();
	}

	private static IAutoFactory createFactoryFromPropertyFile() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		InputStream input=new FileInputStream("Data/factory.properties");
		Properties prop=new Properties();
		prop.load(input);
		 
		 Class<?> clas=Class.forName(prop.getProperty("factory"));
		 Method m=clas.getMethod("getInstance");
		 IAutoFactory factory=(IAutoFactory)m.invoke(null);
		 return factory;
	}
}
