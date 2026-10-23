package com.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class RecordDeletionWithPreparedStatement 
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);) 
		{
			System.out.println("Enter the eid:");
			int eid=sc.nextInt();
			String query="select * from emp where eid=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String query1="delete from emp where eid=?";
				PreparedStatement ps1 = connection.prepareStatement(query1);
				ps1.setInt(1, eid);
				ps1.executeUpdate();
				System.out.println("Record Deleted Sucessfully");
			}
			else
			{
				System.out.println("No Employee found with eid:"+eid);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
