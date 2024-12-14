<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
  </head>
  
  <body>
  <h1>Delete User:</h1>


	<form action="<c:url value='/DeleteUserServlet'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
		<div class="form-group">
			<label for="epic-user-id">User Id</label>
			<input id="epic-user-id" class="form-control" required type="text" name="id" value="${form.id }"/>
			<span style="color: red; font-weight: 900">${errors.id }</span>		
		</div>
		<input type="submit" class="btn btn-primary" value="Delete user"/>
		<a class="btn btn-secondary" href="<c:url value='/jsps/user/crud_home.jsp'/>" target="body">Cancel</a>
	</form>
  </body>
</html>
