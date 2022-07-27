package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Person;
import com.mysql.jdbc.PreparedStatement;

public class UserDao 
{
	public static Connection getconnect()
	{
		Connection con=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp123","root",""); 
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
	public static int savedata(Person m)
	{
		Connection con=UserDao.getconnect();
		int status=0;
		try 
		{
			String sql="insert into person(name,surname,email) values (?,?,?)";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getSurname());
			ps.setString(3, m.getEmail());
			 status=ps.executeUpdate();
		
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Person>viewdata()
	{
		List<Person>list=new ArrayList<>();
		Connection con=UserDao.getconnect();
		try 
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from person");
			ResultSet set =ps.executeQuery();
			
			while(set.next()) 
			{
				int id=set.getInt(1);
				String name=set.getString(2);
				String surname=set.getString(3);
				String email=set.getString(4);
				
				Person p =new Person();
				p.setId(id);
				p.setName(name);
				p.setSurname(surname);
				p.setEmail(email);
				list.add(p);
			}
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static int deletedata(int id){
		int status=0;
		try{
			Connection con=getconnect();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from person where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static Person getemployeebyid(int id)
	{
		
		Person m =new Person();
		
			Connection con =UserDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from person where id=?");
				ps.setInt(1,id);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					
					m.setId(set.getInt(1));
					m.setName(set.getString(2));
					m.setSurname(set.getString(3));
					m.setEmail(set.getString(4));
					
				}
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return m;
		
	}
	
	public static int updatedata(Person m)
	{
		Connection con=UserDao.getconnect();
		
		int status=0;
		
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("update person set name=?,surname=?,email=? where id=?");
			
				ps.setString(1,m.getName());
				ps.setString(2,m.getSurname());
				ps.setString(3,m.getEmail());
				ps.setInt(4, m.getId());
				
				status=ps.executeUpdate();
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return status;
	}
	
/*	public static List<Person>viewdata()
	{
		List<Person>list = new ArrayList<Person>();
		
		Connection con=UserDao.getconnect();
		String sql="select * from person";
		try 
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				int id=set.getInt(1);
				String name=set.getString(2);
				String email=set.getString(3);
				String password=set.getString(4);
				
				Person m =new Person();
				m.setId(id);
				m.setName(name);
				m.setEmail(email);
				m.setPass(password);
				list.add(m);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return list;
	}
	
	public static int deletedata(int id){
		int status=0;
		try{
			Connection con=getconnect();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from person where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static Person getemployeebyid(int id)
	{
		
		Person m =new Person();
		
			Connection con =UserDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from person where id=?");
				ps.setInt(1,id);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					
					m.setId(set.getInt(1));
					m.setName(set.getString(2));
					m.setEmail(set.getString(3));
					m.setPass(set.getString(4));
					
				}
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return m;
		
	}
	
	public static int updatedata(Person m)
	{
		Connection con=UserDao.getconnect();
		
		int status=0;
		
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("update person set name=?,email=?,password=? where id=?");
			
				ps.setString(1,m.getName());
				ps.setString(2,m.getEmail());
				ps.setString(3,m.getPass());
				ps.setInt(4, m.getId());
				
				status=ps.executeUpdate();
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return status;
	}*/
	
	
}
