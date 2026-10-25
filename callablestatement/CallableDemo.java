package com.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class CallableDemo 
{
	public static void main(String[] args) 
	{

		try(Connection connection = DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);) 
		{
			System.out.println("Enter the id:");
			int eid=sc.nextInt();
			System.out.println("Enter the Name:");
			String name=sc.next();
			
			CallableStatement cst=connection.prepareCall("{call getEmpByIdAndName(?,?)}");
			cst.setInt(1, eid);
			cst.setString(2, name);
			ResultSet rs = cst.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String ename=rs.getString(2);
				
				System.out.println(id+" , "+ename);
			}
			else
			{
				System.out.println("No Record exists with id:"+eid+" and name:"+name);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
