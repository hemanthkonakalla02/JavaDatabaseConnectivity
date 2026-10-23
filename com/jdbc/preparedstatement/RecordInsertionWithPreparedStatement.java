package com.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class RecordInsertionWithPreparedStatement 
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);) 
		{
			System.out.println("Enter the eid:");
			int eid=sc.nextInt();
			System.out.println("Enter the ename:");
			String ename=sc.next();
			sc.nextLine();
			System.out.println("Enter the salary:");
			float salary=sc.nextFloat();
			System.out.println("Enter the address:");
			String address=sc.next();
			sc.nextLine();
			System.out.println("Enter the dept:");
			String dept=sc.next();
			
			String query="insert into emp(eid,ename,salary,address,dept) values(?,?,?,?,?)";
			
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setFloat(3, salary);
			ps.setString(4, address);
			ps.setString(5, dept);
			ps.executeUpdate();
			System.out.println("Record Inserted Sucessfully");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
