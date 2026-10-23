package com.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class TableCreationAndRecordInsertion 
{
	public static void main(String[] args) 
	{
		//Table Creation
		Connection connection = DatabaseConnection.getConnection();
		String query="create table dummy(eid int,ename varchar(45))";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.execute();
			System.out.println("Table Created Sucessfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		//Record Insertion
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the eid:");
		int eid=sc.nextInt();
		System.out.println("Enter the ename:");
		String ename=sc.next();
		
		String query1="insert into dummy values(?,?)";
		try {
			PreparedStatement ps1=connection.prepareStatement(query1);
			ps1.setInt(1, eid);
			ps1.setString(2, ename);
			ps1.executeUpdate();
			System.out.println("Record inserted sucessfully");
		} catch (SQLException e) {
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
