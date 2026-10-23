package com.jdbc.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.DatabaseConnection;

public class DroppingTable 
{
	public static void main(String[] args) 
	{
		
		try(Connection con=DatabaseConnection.getConnection();
				Statement st = con.createStatement();) 
		{
			
			String query="drop table emp";
			st.executeUpdate(query);
			System.out.println("Table Dropped Sucessfully");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
