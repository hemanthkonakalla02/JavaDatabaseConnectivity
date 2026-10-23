package com.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class DisplayParticularRecordUsingPreparedStatement 
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
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float salary=rs.getFloat(3);
				String address=rs.getString(4);
				String dept=rs.getString(5);
				
				System.out.println(id+" , "+name+" , "+salary+" , "+address+" , "+dept);
			}
			else
			{
				System.out.println("No Employee Found with eid:"+eid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
