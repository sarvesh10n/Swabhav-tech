package com.techlabs.unit.test;

import java.io.IOException;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.techlabs.connection.MakeConnection;

public class UnitTest {
	
	@Test
	public void checkConnection() throws ClassNotFoundException, IOException{
		MakeConnection connections=new MakeConnection();
		Connection conn=connections.getConnection();
	}
}
