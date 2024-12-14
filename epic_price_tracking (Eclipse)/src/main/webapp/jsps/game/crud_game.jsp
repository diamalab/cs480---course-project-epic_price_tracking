<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>GAME CRUD</title>
    
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
  <h1>Game CRUD Operations: </h1>
  <a href="<c:url value='/findAllgames'/>" target="body">Read All Games</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/game/create2.jsp'/>" target="body">Create Game</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/game/update2.jsp'/>" target="body">Update Game</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/game/delete2.jsp'/>" target="body">Delete Game</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/game/price_drop_user.jsp'/>" target="body">My Price Drops</a>&nbsp;&nbsp;

  </body>
</html>
