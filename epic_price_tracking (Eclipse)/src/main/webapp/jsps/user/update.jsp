<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Database</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update User:</h1>


	<form action="<c:url value='/UpdateUserServlet'/>" method="post">
	<input type="hidden" name="method" value="login"/>
		<div class="form-group">
			<label for="epic-user-id">User Id</label>
			<input id="epic-user-id" class="form-control" required type="text" name="id" value="${form.id }"/>
			<span style="color: red; font-weight: 900">${errors.id }</span>		
		</div>
		<div class="form-group">
			<label for="epic-user-name">Name</label>
			<input id="epic-user-name" class="form-control" required type="text" name="username" value="${form.username }"/>
			<span style="color: red; font-weight: 900">${errors.username }</span>
		</div>	
		<div class="form-group">
			<label for="epic-user-password">Password</label>
			<input id="epic-user-password" class="form-control" required type="password" name="password" value="${form.password }"/>
			<span style="color: red; font-weight: 900">${errors.password }</span>
		</div>	
		<div class="form-group">	
			<label for="epic-user-email">Email address</label>
			<input id="epic-user-email" class="form-control" required type="email" name="email" value="${form.email }"/>
			<span style="color: red; font-weight: 900">${errors.email }</span>
		</div>
		<input type="submit" class="btn btn-primary" value="Update user"/>
		<a class="btn btn-secondary" href="<c:url value='/jsps/user/crud_home.jsp'/>" target="body">Cancel</a>
	</form>

  </body>
</html>
