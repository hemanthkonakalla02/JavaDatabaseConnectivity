package com.jdbc.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class JDBCTransactions 
{
	public static void main(String[] args) 
	{
		Connection connection = DatabaseConnection.getConnection();
		try {
			connection.setAutoCommit(false); //Autocommit is turned off
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the eid:");
		int eid=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the name:");
		String ename=sc.nextLine();
		
		System.out.println("Enter the salary:");
		float salary=sc.nextFloat();
		sc.nextLine();
		
		System.out.println("Enter the address:");
		String address=sc.nextLine();
	
		System.out.println("Enter the department:");
		String dept=sc.nextLine();
		
		
		String query="insert into emp values(?,?,?,?,?)";
		try(PreparedStatement ps=connection.prepareStatement(query);) {
			
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setFloat(3, salary);
			ps.setString(4, address);
			ps.setString(5, dept);
			ps.executeUpdate();
			connection.commit();  //Manually commiting
			System.out.println("Record Inserted Sucessfully");
		} 
		
		catch (SQLException e) 
		{
			try {
				connection.rollback(); //If any exception occurs data will be rolledback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally
		{
			if(connection!=null)
			{
				try {
					connection.close();
					sc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
