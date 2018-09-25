package org.eustrosoft.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;



public class TestJdbc {
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			
			//Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			//DriverManager.registerDriver(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println(myConn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
