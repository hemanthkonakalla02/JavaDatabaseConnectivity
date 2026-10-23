package com.jdbc.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class RecordInsertionWithStatement 
{
	public static void main(String[] args) 
	{

		try(Connection con=DatabaseConnection.getConnection();
				Scanner sc = new Scanner(System.in);
				Statement st=con.createStatement();) 
		{
			System.out.println("Enter the eid:");
			int eid=sc.nextInt();
			System.out.println("Enter the ename:");
			String ename=sc.next();
			sc.nextLine();
			System.out.println("Enter the salary:");
			float salary=sc.nextFloat();
			System.out.println("Enter the department:");
			String dept=sc.next();
			sc.nextLine();
			System.out.println("Enter the address:");
			String address=sc.next();
			
			String query = "insert into emp values('"+eid+"','"+ename+"','"+salary+"','"+dept+"','"+address+"')";
			st.executeUpdate(query);
			System.out.println("Record Inserted Sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
