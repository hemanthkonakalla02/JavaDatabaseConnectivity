package com.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.util.DatabaseConnection;

public class DisplayAllRecordsUsingPreparedStatement 
{
	public static void main(String[] args) 
	{
		Connection connection = DatabaseConnection.getConnection();
		String query="select * from emp";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int eid=rs.getInt(1);
				String ename=rs.getString(2);
				float salary=rs.getFloat(3);
				String address=rs.getString(4);
				String dept=rs.getString(5);
				System.out.println(eid+" , "+ename+" , "+salary+" , "+address+" , "+dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
