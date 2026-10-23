package com.jdbc.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class RecordUpdationWithStatement 
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);
				Statement st=connection.createStatement();) 
		{
			System.out.println("Enter the eid:");
			int eid=sc.nextInt();
			String query="select * from emp where eid='"+eid+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				System.out.println("Enter the updated salary:");
				float salary=sc.nextFloat();
				Statement statement = connection.createStatement();
				String query1="update emp set salary='"+salary+"' where eid='"+eid+"'";
				statement.executeUpdate(query1);
				System.out.println("Salary Updated Sucessfully");
				
			}
			else
			{
				System.out.println("No Employee exists with id:"+eid);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
