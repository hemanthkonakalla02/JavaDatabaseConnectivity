package com.jdbc.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

//Thier is a SQL injection problem because of Statement
public class LoginPage 
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);) 
		{
			System.out.println("Enter the username:");
			String username=sc.nextLine();
		
			System.out.println("Enter the password:");
			String password=sc.next();
			
			Statement st=connection.createStatement();
			String query="select * from signup where name='"+username+"' and password='"+password+"'";
		
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				System.out.println("Login sucessful");
			}
			else
			{
				System.out.println("Invalid username/password");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
