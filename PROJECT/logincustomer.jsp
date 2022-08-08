<%@page import="com.dao.WebDao"%>
<%@page import="com.model.SignupModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		SignupModel m =new SignupModel();
		m.setEmail(email);
		m.setPassword(password);
		
		SignupModel m2 = WebDao.CheckLogin(m);
		if(m2!=null)
		{
			session.setAttribute("webwing",true);
			session.setAttribute("myemail",m2.getEmail());
			session.setAttribute("myname",m2.getName());
			session.setAttribute("mymobile",m2.getMobile());
			
			response.sendRedirect("home.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>