<%@page import="com.dao.WebDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <jsp:useBean id="product12" class="com.model.CartModel"></jsp:useBean>
    <jsp:setProperty property="*" name="product12"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

			<h1>WishList</h1>
		

		<%
		
		int status123 = WebDao.Wish12(product12);
		
		//System.out.println(status123);
		
		if (status123 > 0) 
		{
			out.print("Product Added");
		}
		else 
		{
			out.print("Product Already Added");
		}
		%>



</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>