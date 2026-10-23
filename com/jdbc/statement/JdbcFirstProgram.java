package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcFirstProgram 
{
	public static void main(String[] args) 
	{
		//Load the Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Sucessfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Establish the connection with database
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccomplete", "root","root");
			System.out.println("Connection established sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
					System.out.println("Connection closed sucessfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
