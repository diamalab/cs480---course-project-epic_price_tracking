<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
</head>
<body>
	<h3 align="center"> User Table </h3>
	<table class="table" align="center">
	<tr>
		<th>id</th>
	
		<th>name</th>
		<th>email</th>
	</tr>
<c:forEach items="${UserList}" var="user">
	<tr>
		<td>${user.id }</td>
	
		<td>${user.username }</td>
		<td>${user.email }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>