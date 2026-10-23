package com.jdbc.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class RecordDeletionWithStatement 
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
				String query1="delete from emp where eid='"+eid+"'";
				Statement statement = connection.createStatement();
				statement.executeUpdate(query1);
				System.out.println("Record deleted sucessfully");
				
			}
			else
			{
				System.out.println("No Employee Found with id:"+eid);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
