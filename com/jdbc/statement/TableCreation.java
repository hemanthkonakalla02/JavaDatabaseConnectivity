package com.jdbc.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.DatabaseConnection;

public class TableCreation 
{
	public static void main(String[] args) 
	{
		
		try(Connection con=DatabaseConnection.getConnection();
				Statement st = con.createStatement();) 
		{
			
			String query="create table emp(eid int,ename varchar(45),salary float,address varchar(45))";
			st.executeUpdate(query);
			System.out.println("Table Created Sucessfully");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
