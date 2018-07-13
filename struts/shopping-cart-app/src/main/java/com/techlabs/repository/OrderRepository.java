package com.techlabs.repository;

import java.io.IOException;

import com.mysql.jdbc.Connection;

public class OrderRepository {

	Connection conn;
	public OrderRepository() throws ClassNotFoundException, IOException{
		conn=new MakeConnection().getConnection();
	}
	
	public void addOrder(){
		String query="INSERT INTO ORDER VALUES()";
	}
}
