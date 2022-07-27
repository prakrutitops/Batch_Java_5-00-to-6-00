<%@page import="com.model.Person"%>
<%@page import="com.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<%
		List<Person> list=UserDao.viewdata();
		request.setAttribute("tops",list);
	%>
	
	<table border="1" width="50%">
	
		<tr><th>Id</th><th>Name</th><th>Surname</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
		
		<c:forEach items="${tops}" var="m">
		
			<tr><td>${m.getId()}</td><td>${m.getName()}</td><td>${m.getSurname()}</td><td>${m.getEmail()}</td><td><a href="edit.jsp?id=${m.getId()}">Edit</a></td><td><a href="delete.jsp?id=${m.getId()}">Delete</a></td></tr>
		
		</c:forEach>
	</table>
	
	<a href="index.html">Add Data</a>

</body>
</html>