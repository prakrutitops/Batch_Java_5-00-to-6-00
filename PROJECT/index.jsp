<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <jsp:include page="header.jsp"></jsp:include>
 		
 		<body>
 			
 			<%
 				if(session.getAttribute("webwing")!=null)
 				{
 					
 				
 			
 			%>
 			 <a href="profile.jsp"><img alt="error" src="images/profile.png" width="50px" height="50px" style="margin-left: 1150px;"></a>
 			 
 			 <%
 			 	}
 			 %>
 		
 		
 		</body>
   
   	<jsp:include page="footer.jsp"></jsp:include>
   