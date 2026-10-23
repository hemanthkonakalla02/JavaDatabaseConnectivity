package com.jdbc.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.DatabaseConnection;

public class DisplayTableData 
{
	public static void main(String[] args) 
	{
		
		try(Connection connection = DatabaseConnection.getConnection();
				Statement st = connection.createStatement();) {
			
			String query="select * from emp";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				int eid=rs.getInt(1);
				String name=rs.getString(2);
				float salary=rs.getFloat(3);
				String address = rs.getString(4);
				String dept=rs.getString(5);
				
				System.out.println(eid+" , "+name+" , "+salary+" , "+address+" , "+dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
