<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/signup.css">

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">








	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
		<h4 class="card-title mt-3 text-center">Create Account</h4>
		<p class="text-center">Get started with your free account</p>
		<p>
			<a href="" class="btn btn-block btn-twitter"> <i
				class="fab fa-twitter"></i> Logn via twiter
			</a> <a href="" class="btn btn-block btn-facebook"> <i
				class="fab fa-facebook-f"></i> Login via facebook
			</a>
		</p>
		<p class="divider-text">
			<span class="bg-light">OR</span>
		</p>
		<form action="registercustomer.jsp">
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-user"></i>
					</span>
				</div>
				<input name="name" class="form-control" placeholder="Full name"
					type="text">
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-envelope"></i>
					</span>
				</div>
				<input name="email" class="form-control" placeholder="Email address"
					type="email">
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-phone"></i>
					</span>
				</div>
				<select class="custom-select" style="max-width: 120px;">
					<option selected="">+91</option>
					<option value="1">+1</option>

				</select> <input name="mobile" class="form-control"
					placeholder="Phone number" type="text">
			</div>
			<!-- form-group// -->
			<!-- <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control">
			<option selected=""> Select job type</option>
			<option>Designer</option>
			<option>Manager</option>
			<option>Accaunting</option>
		</select>
	</div> form-group end.// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-lock"></i>
					</span>
				</div>
				<input class="form-control" placeholder="Create password" name="password" type="password">
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-lock"></i>
					</span>
				</div>
				<input name="repassword" class="form-control"
					placeholder="Repeat password" type="password">
			</div>
			<!-- form-group// -->
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">
					Create Account</button>
			</div>
			<!-- form-group// -->
			<p class="text-center">
				Have an account? <a href="login.jsp">Log In</a>
			</p>
		</form>
		</article>
	</div>
	<!-- card.// -->

	</div>
	<!--container end.//-->
		
		<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>