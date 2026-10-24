package com.jdbc.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class RegistrationPage
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);) 
		{
			System.out.println("Enter the username:");
			String uname=sc.next();
			sc.nextLine();
			System.out.println("Enter the password:");
			String pwd=sc.next();
			String query="insert into signup values (?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.executeUpdate();
			
			System.out.println("Registration is sucessfull");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
