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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
  </head>
  
  <body>
  <h1>Update Game:</h1>


	<form action="<c:url value='/UpdateGameServlet'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
		<div class="form-group">
			<label for="epic-game-id">Game Id</label>
			<input id="epic-game-id" class="form-control" required type="text" name="id" value="${form.id }"/>
			<span style="color: red; font-weight: 900">${errors.id }</span>
		</div>	
		<div class="form-group">
			<label for="epic-game-name">Name</label>
			<input id="epic-game-name" class="form-control" required type="text" name="name" value="${form.name }"/>
			<span style="color: red; font-weight: 900">${errors.name }</span>
		</div>	
		<div class="form-group">
			<label for="epic-game-thumbnail">Thumbnail</label>
			<input id="epic-game-thumbnail" class="form-control" required type="password" name="thumbnail" value="${form.thumbnail }"/>
			<span style="color: red; font-weight: 900">${errors.thumbnail }</span>
		</div>	
		<div class="form-group">	
			<label for="epic-game-price">Price</label>
			<input id="epic-game-price" class="form-control" required type="text" name="price" value="${form.price }"/>
			<span style="color: red; font-weight: 900">${errors.price }</span>
		</div>
		<input type="submit" class="btn btn-primary" value="Update Game"/>
		<a class="btn btn-secondary" href="<c:url value='/jsps/game/crud_game.jsp'/>" target="body">Cancel</a>
	</form>

  </body>
</html>
