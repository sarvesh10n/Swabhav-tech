package com.techlabs.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class MakeConnection {
	Connection conn;
	
	public Connection getConnection() throws ClassNotFoundException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream input = classLoader
					.getResourceAsStream("com/techlabs/connection/app.config.properties");
			Properties properties=new Properties();
			properties.load(input);
			String url=properties.getProperty("link");
			conn = (Connection) DriverManager
					.getConnection(url);
			System.out.println("Connection done!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return (Connection) conn;
	}

}
