<%@page import="java.util.Iterator"%>
<%@page import="com.model.SignupModel"%>
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
	
	<%CartModel cm=null; %>
	<%
	
	if (session.getAttribute("myemail") != null)
	{
			//out.print(session.getAttribute("myemail"));
			String myemail=session.getAttribute("myemail").toString();
			List<CartModel> list=WebDao.getwishbyemail(myemail);
			
			
			request.setAttribute("tops",list);
			
			
			
	}
	else
	{
		out.print("does not fetch any data");
	}
		
	
		//System.out.println(request.getParameter("email"));
	
		//request.setAttribute("i",c);
	%>
	
	
	<table border="1" width="50%">
	
		<tr><th>Id</th><th>Name</th></tr>
		
		<c:forEach items="${tops}" var="m">
		
			<tr>
				<td>${m.getId()}</td>
			
				<td>${m.getProduct_name()}</td>
				
				<p>
					<img width="100px" height="100px" src="${m.getProduct_image()}">
				</p>
			
			</tr>
			
		
		
		</c:forEach>
	</table>
	
	
	<%-- <center>
			
	     		<br>
				<br>
				
				
				<c:forEach items="${i}" var="a1">
					<p>
						<h2><%=a1.get %></h2>
					</p>
					
					<p>
						<img width="500px" height="200px" src="${m.getProduct_image()}">
					</p>
				</c:forEach>
				 
			</center>
	

		<c:forEach >
			
			
			
		</c:forEach> --%>
	
<jsp:include page="footer.jsp"></jsp:include>
		

</body>
</html>