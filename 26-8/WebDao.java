package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.model.CartModel;
import com.model.ContactModel;
import com.model.ImageModel;

import com.model.SignupModel;

public class WebDao {

	public static Connection getconnect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webwing", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static int RegisterCoustomer(SignupModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			java.sql.PreparedStatement ps = con
					.prepareStatement("insert into signup(name,email,mobile,password) values(?,?,?,?)");

			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getMobile());
			ps.setString(4, m.getPassword());

			status = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;
	}

	public static SignupModel LoginCoustomer(SignupModel model) {
		boolean flag = false;

		SignupModel obj = null;

		try {
			Connection con = WebDao.getconnect();
			PreparedStatement ps = con.prepareStatement("select * from signup where email=? and password=?");
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				obj = new SignupModel();
				obj.setName(rs.getString("name"));
				obj.setEmail(rs.getString("email"));
				obj.setMobile(rs.getString("mobile"));
				obj.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
	
	
	public static int ContactForm(ContactModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			PreparedStatement ps = con
					.prepareStatement("insert into contactus(name,email,subject,message) values(?,?,?,?)");

			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getSubject());
			ps.setString(4, m.getMessage());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}
	
	public static List<ImageModel> getAll()
	{
		List<ImageModel> i = new ArrayList<ImageModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from product");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				ImageModel d1 = new ImageModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setName(rs.getString(2));
				d1.setImage(rs.getString(3));
				i.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	public static ImageModel getproductdetail(int id)
	{
		
		ImageModel m =new ImageModel();
		
			Connection con =WebDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from products where id=?");
				ps.setInt(1,id);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					m.setId(set.getInt(1));
					m.setName(set.getString(2));
					m.setImage(set.getString(3));
	
				}
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return m;
		
	}
	
	public static int Cart12(CartModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			PreparedStatement ps = con.prepareStatement("insert into cart123(id,product_name,product_image) values(?,?,?)");

			ps.setInt(1, m.getId());
			ps.setString(2, m.getProduct_name());
			ps.setString(3, m.getProduct_image());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}	
	
	public static int Wish12(CartModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			PreparedStatement ps = con.prepareStatement("insert into wishlist(id,product_name,product_image) values(?,?,?)");

			ps.setInt(1, m.getId());
			ps.setString(2, m.getProduct_name());
			ps.setString(3, m.getProduct_image());
		

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}	
	
	public static List<CartModel> getallcartdetail()
	{
		List<CartModel> i = new ArrayList<CartModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from cart123");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				CartModel d1 = new CartModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				i.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

	
	public static List<CartModel> getallwishdetail()
	{
		List<CartModel> i = new ArrayList<CartModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wishlist");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				CartModel d1 = new CartModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				i.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	
	public static List<CartModel> getwishbyemail(String email)
	{//SELECT COUNT(product_name) FROM wishlist WHERE email ='darshit@gmail.com'

		List<CartModel> list = new ArrayList<CartModel>();
		CartModel d1 = new CartModel();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wishlist where email=?");
		
			ps.setString(1,email);
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			
			while(rs.next())
			{
				
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				
				list.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	
	public static int getCustEmailWish(int id)
	{
		int r = 0;
		
			try {
				
				Connection con = WebDao.getconnect();
				PreparedStatement ps = con.prepareStatement("SELECT id FROM `wishlist` WHERE id=?");
				PreparedStatement p = con.prepareStatement("SELECT * FROM `wishlist` WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					r = rs.getInt("Cust_ID");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		
		return r;
	}
	
	
	/*public static SignupModel getemployeebyid(String email)
	{
		
		SignupModel m =new SignupModel();
		
			Connection con =WebDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from signup where email=?");
				ps.setString(1,email);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					
					
					
					m.setId(set.getInt(1));
					m.setName(set.getString(2));
					m.setEmail(set.getString(3));
					m.setMobile(set.getString(4));
					m.setPassword(set.getString(5));
					
					System.out.println(m.getEmail());
					
				}
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return m;
		
	}*/
	
	

	
	
	
}