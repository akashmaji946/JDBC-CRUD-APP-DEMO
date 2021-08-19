package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCreator {

	private static Connection con;

	public  static Connection createCon() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/Students_Manage";
			String user = "root";
			String pass = "akash";
			
			con = DriverManager.getConnection(url, user, pass);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
		
		
	}
	
	
	
	

}
