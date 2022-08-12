<%@page import="com.dao.WebDao"%>
<%@page import="com.model.CartModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		List<CartModel> list=WebDao.getallcartdetail();
		request.setAttribute("i",list);
	%>


		<c:forEach items="${i}" var="m">
			<center>
			
			
				<br>
				<br>
				
				<p>
					<h2>${m.getProduct_name()}</h2>
				</p>
				
				
		
				<p>
					<img width="500px" height="200px" src="${m.getProduct_image()}">
				</p>
				
			
				
				
			</center>
			
			
		</c:forEach>
	
<jsp:include page="footer.jsp"></jsp:include>
		

</body>
</html>