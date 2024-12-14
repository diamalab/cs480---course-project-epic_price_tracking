<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
	<script ><%@include file="/WEB-INF/lib/js/bootstrap.min.js"%></script>
	<script
			  src="https://code.jquery.com/jquery-3.6.0.slim.js"
			  integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
			  crossorigin="anonymous"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href=<c:url value='/jsps/body.jsp'/> target="body">Epic Games Tracker</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <c:choose>
		<c:when test="${empty sessionScope.session_user }">
		<li class="nav-item ">
        	<a class="nav-link" href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>
      	</li>
		</c:when>
		<c:otherwise>
		<li class="nav-item">
        	<a class="nav-link" href="<c:url value='/jsps/item.jsp'/>" target="body">Initialize Database</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<c:url value='/jsps/HomePage.jsp'/>" target="body">Home</a>
      	</li>
      	<li class="nav-item ">
        	<a class="nav-link" href="<c:url value='/jsps/user/crud_home.jsp'/>" target="body">User</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<c:url value='/jsps/game/crud_game.jsp'/>" target="body">Game</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<c:url value='/jsps/genre/crud_genre.jsp'/>" target="body">Genre</a>
      	</li>
        <li class="nav-item">
        	<a class="nav-link" href="<c:url value='/jsps/publisher/crud_publisher.jsp'/>" target="body">Publisher</a>
      	</li>
      	<li class="nav-item">
<%--       	<form id="my_list_form" action="<c:url value='/CreateServlet2'/>" method="get" target="body">
      		<input hidden type="text" name="userId" value=" ${sessionScope.session_user.id}">
      		<a class="nav-link" type="submit" target="body" onclick="document.getElementById('my_list_form').submit(); return false;" >My Tracking List</a>
      	</form> --%>
      		<a class="nav-link" id="my-tracking-list" href="<c:url value='/UserGame'/>" target="body">My Tracking List</a>
      	</li>
		</c:otherwise>
	</c:choose>
    </ul>
    <span class="navbar-text">
    	Welcome, ${sessionScope.session_user.username }
    </span>
  </div>
</nav>
 <!-- ------------------------ --> 
<%-- <h1 style="text-align: center;">epic_price_tracking</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>	|&nbsp; 
			
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };<br/>
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Initialize Database</a>   |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/user/crud_home.jsp'/>" target="body">User</a>	|&nbsp; 
			<a href="<c:url value='/jsps/game/crud_game.jsp'/>" target="body">Game</a>	|&nbsp; 
			<a href="<c:url value='/jsps/publisher/crud_publisher.jsp'/>" target="body">Publisher</a> |&nbsp; 
			<a href="<c:url value='/jsps/genre/crud_genre.jsp'/>" target="body">Genre</a>	|&nbsp; 

		</c:otherwise>
	</c:choose>

</div> --%>
  </body>
</html>
