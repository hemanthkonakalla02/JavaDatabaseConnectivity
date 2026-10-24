package com.jdbc.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

//Solution for SQL Injection Problem 
//using PreparedStatement
public class LoginPageWithPreparedStatement 
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);) 
		{
			System.out.println("Enter the username:");
			String name=sc.nextLine();
			System.out.println("Enter the password:");
			String password=sc.nextLine();
			String query="select * from signup where name=? and password=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Login Sucessful");
			}
			else
			{
				System.out.println("Invalid username/password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
