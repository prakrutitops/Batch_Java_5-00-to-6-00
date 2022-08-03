package com.servlet;
/*

ServletConfig config;
	ServletConfig is used for one servlet
	Data shared with only one servlet and than you
	want to fetch it ServletConfig will be used
	
ServletContext context;
	ServletContext is used for all servlet
	Commonlly shared data can be fetched from ServletContext
	
*/
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {

       
	String email,driver;
	ServletConfig config;
	ServletContext context;
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		this.context=config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		email=config.getInitParameter("email");
		System.out.println(email);
		
		driver=context.getInitParameter("driver");
		System.out.println(driver);
		
		
		//WebApp -> Context-> Direct Start
		//WebApp ->Servlet -> Check  -> Launch Context
		
		
		
		
		
	}

}
