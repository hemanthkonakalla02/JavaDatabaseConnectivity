package com.jdbc.crudoperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.util.DatabaseConnection;

public class CRUDApplication 
{
	static Connection connection = DatabaseConnection.getConnection();
	static Scanner sc = new Scanner(System.in);
	static PreparedStatement ps=null;
	public static void main(String[] args) 
	{	
		
		while(true)
		{
			System.out.println("1.Table Creation");
			System.out.println("2.Record Insertion");
			System.out.println("3.Update Record");
			System.out.println("4.Delete Record Based on Id:");
			System.out.println("5.Delete All Records");
			System.out.println("6.Display Record Based on Id:");
			System.out.println("7.Display All Records");
			System.out.println("8.Exit");
			
			System.out.println("Enter the choice:");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			   case 1 -> tableCreation();
			   case 2 -> recordInsertion();
			   case 3 -> updateRecord();
			   case 4 -> deleteRecordBasedOnId();
			   case 5 -> deleteAllRecords();
			   case 6 -> displayRecordBasedOnId();
			   case 7 -> displayAllRecords();
			   case 8 -> System.exit(0);
			}	
		}
	}
	
	
	public static void tableCreation()
	{
		String query="create table employs(eid int,ename varchar(45),salary float,dept varchar(45))";
		try 
		{
			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Table Created Sucessfully");
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void recordInsertion()
	{
		System.out.println("Enter the eid:");
		int eid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the ename:");
		String ename=sc.nextLine();
		System.out.println("Enter the salary:");
		float salary=sc.nextFloat();
		sc.nextLine();
		System.out.println("Enter the dept:");
		String dept=sc.nextLine();
		
		
		String query="insert into employs values(?,?,?,?)";
		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setFloat(3, salary);
			ps.setString(4, dept);
			ps.executeUpdate();
			System.out.println("****** RECORD INSERTED SUCESSFULLY ******");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void updateRecord()
	{
		System.out.println("Enter the eid:");
		int eid=sc.nextInt();
		String query1="select * from employs where eid=?";
		try {
			ps=connection.prepareStatement(query1);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Enter the updated salary:");
				float salary=sc.nextFloat();
				
				String query2="update employs set salary=? where eid=?";
				ps=connection.prepareStatement(query2);
				ps.setFloat(1, salary);
				ps.setInt(2, eid);
				ps.executeUpdate();
				
				System.out.println("****** RECORD UPDATED SUCESSFULLY ******");
			}
			else
			{
				System.out.println("No Employee Found with id:"+eid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void deleteRecordBasedOnId()
	{
		System.out.println("Enter the eid:");
		int eid=sc.nextInt();
		String query1="select * from employs where eid=?";
		try {
			ps=connection.prepareStatement(query1);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String query2="delete from employs where eid=?";
				ps=connection.prepareStatement(query2);
				ps.setInt(1, eid);
				ps.executeUpdate();
				System.out.println("****** RECORD DELETED SUCESSFULLY ******");

			}
			else
			{
				System.out.println("No Employee Found with id:"+eid);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void deleteAllRecords()
	{
		String query1="select * from employs";
		try {
			ps=connection.prepareStatement(query1);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String query2="delete from employs";
				try {
					ps=connection.prepareStatement(query2);
					ps.executeUpdate();
					System.out.println("****** ALL RECORDS DELETED SUCESSFULLY ******");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("No Records in Table");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void displayRecordBasedOnId()
	{
		System.out.println("Enter the eid:");
		int eid=sc.nextInt();
		String query1="select * from employs where eid=?";
		try {
			ps=connection.prepareStatement(query1);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float salary=rs.getFloat(3);
				String dept=rs.getString(4);
				
				System.out.println(id+" , "+name+" , "+salary+" , "+dept);
			}
			else
			{
				System.out.println("No Employee Found with id:"+eid);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void displayAllRecords()
	{
		String query1="select * from employs";
		try {
			ps=connection.prepareStatement(query1);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String query2="select * from employs";
				ps=connection.prepareStatement(query2);
				ResultSet rs1 = ps.executeQuery();
				while(rs1.next())
				{
					int id=rs1.getInt(1);
					String name=rs1.getString(2);
					float salary=rs1.getFloat(3);
					String dept=rs1.getString(4);
					
					System.out.println(id+" , "+name+" , "+salary+" , "+dept);
				}
			}
			else
			{
				System.out.println("No Records in Table");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
