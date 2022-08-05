package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.SignupModel;

public class WebDao 
{
	
	
	public static Connection getconnect()
	{
		Connection con=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webwing8","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static int Adddata(SignupModel m)
	{
		int status=0;
		
		Connection con=WebDao.getconnect();
		
		try 
		{
			PreparedStatement ps=con.prepareStatement("insert into signup(name,email,mobile,password)values(?,?,?,?)");
			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getMobile());
			ps.setString(4, m.getPassword());
			
			status=ps.executeUpdate();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return status;
	}
	
	public static SignupModel CheckLogin(SignupModel model)
	{
		boolean flag = false;

		SignupModel obj = null;
		
		try
		{
			Connection con= WebDao.getconnect();
			PreparedStatement ps =con.prepareStatement("select * from signup where email=? and password=?");
			ps.setString(1, model.getEmail());
			ps.setString(2,model.getPassword());
			
			ResultSet set=ps.executeQuery();
			
			while(set.next())
			{
				
				obj = new SignupModel();
				obj.setName(set.getString("name"));
				obj.setEmail(set.getString("email"));
				obj.setMobile(set.getString("mobile"));
				obj.setPassword(set.getString("password"));

			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return obj;
	}
}
