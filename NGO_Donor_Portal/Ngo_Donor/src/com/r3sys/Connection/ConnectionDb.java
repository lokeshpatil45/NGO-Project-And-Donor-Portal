package com.r3sys.Connection;
import java.sql.*;
public class ConnectionDb 
{

	static Connection cn=null;
	public static Connection getConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3310/ngodb","root","");
			System.out.println("connected successfully"+cn);
		}
		catch(Exception e)
		{
			 System.out.println("Connection failed..!!!!!!");
			 e.printStackTrace();
		}
		return cn;
	}
	
}
