<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>GENRE CRUD</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Genre CRUD Operations: </h1>
  <a href="<c:url value='/findAll'/>" target="body">Read All Genres</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/user/create.jsp'/>" target="body">Create Genre</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/user/update.jsp'/>" target="body">Update Genre</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/user/delete.jsp'/>" target="body">Delete Genre</a>&nbsp;&nbsp;

  </body>
</html>
