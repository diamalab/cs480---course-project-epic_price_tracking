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
	<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="container-fluid">
  	    <h3>Initialize the Database</h3>
    <br>
    <form action="<c:url value='/InitializeDB'/>" method="post">
		<input type="submit" class="btn btn-primary" value="Click to Initialize the database."/>
	</form>  
  </div> 
  </body>
</html>
