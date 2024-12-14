<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Database</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
  </head>
  
  <body>
  <h1>Create new Genre:</h1>


	<form action="<c:url value='/CreateGenre'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
		<div class="form-group">
			<label for="epic-genre-name">Name</label>
			<input id="epic-genre-name" class="form-control" required type="text" name="name" value="${form.name }"/>
			<span style="color: red; font-weight: 900">${errors.name }</span>
		</div>	
		<div class="form-group">
			<label for="epic-genre-parent">Parent Genre</label>
			<input id="epic-genre-parent" class="form-control" type="text" name="parentGenre" value="${form.parentGenre }"/>
			<span style="color: red; font-weight: 900">${errors.parentGenre }</span>
		</div>	
		<input type="submit" class="btn btn-primary" value="Create Genre"/>
		<a class="btn btn-secondary" href="<c:url value='/jsps/genre/crud_genre.jsp'/>" target="body">Cancel</a>
	</form>

  </body>
</html>
