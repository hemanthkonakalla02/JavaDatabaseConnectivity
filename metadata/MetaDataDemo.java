package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jdbc.util.DatabaseConnection;

public class MetaDataDemo 
{
	public static void main(String[] args) 
	{
		Connection connection = DatabaseConnection.getConnection();
		String query="select * from emp";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			System.out.println(metaData.getTableName(1));//emp
			System.out.println(metaData.getColumnName(1));//eid
			System.out.println(metaData.getColumnTypeName(2));//Varchar
			System.out.println(metaData.getColumnCount());//5
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
