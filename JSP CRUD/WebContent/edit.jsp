<%@page import="com.model.Person"%>
<%@page import="com.dao.UserDao"%>
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
		String id=request.getParameter("id");
		int id2=Integer.parseInt(id);
		Person m=UserDao.getemployeebyid(id2);
	%>


<form action="edit2.jsp">

		<p>
			<input type="hidden" name="id" value="<%=m.getId() %>">
		</p>
		
		<p>
			Enter Name:<input type="text" name="name" value="<%=m.getName() %>">
		</p>


		<p>
			Enter Surname:<input type="text" name="surname" value="<%=m.getSurname()%>">
		</p>


		<p>
			Enter Email:<input type="text" name="email" value="<%= m.getEmail()%>">
		</p>
		
		<p>
			<input type="submit" value="Go">
		</p>

	</form>
</body>
</html>