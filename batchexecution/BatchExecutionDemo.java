package com.jdbc.batchexecution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class BatchExecutionDemo 
{
	public static void main(String[] args) 
	{
		Connection connection = DatabaseConnection.getConnection();
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps=null;
		String query="insert into emp values(?,?,?,?,?)";
		try {
			ps=connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while(true)
		{
			System.out.println("Enter the eid:");
			int eid=sc.nextInt();
			System.out.println("Enter the name:");
			String name=sc.next();
			sc.nextLine();
			System.out.println("Enter the salary:");
			float salary=sc.nextFloat();
			System.out.println("Enter the address:");
			String address=sc.next();
			sc.nextLine();
			System.out.println("Enter the dept:");
			String dept=sc.next();
			
			try
			{
				ps.setInt(1, eid);
				ps.setString(2, name);
				ps.setFloat(3, salary);
				ps.setString(4, address);
				ps.setString(5, dept);
				ps.addBatch();
			} 
			catch (SQLException e) 
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
			
			
			
			System.out.println("You want to enter one more employee details (y/n):");
			String res=sc.next();
			if(res.equalsIgnoreCase("N"))
			{
				break;
			}
			
			
		}
		
		try 
		{
			ps.executeBatch();
			System.out.println("Records Inserted Sucessfully");
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
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
