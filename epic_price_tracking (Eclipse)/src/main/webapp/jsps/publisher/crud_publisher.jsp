<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Publisher CRUD</title>
    
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
  <h1>Publisher CRUD Operations: </h1>
  <a href="<c:url value='/findAllPublisher'/>" target="body">Read All Publishers</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/publisher/create.jsp'/>" target="body">Create Publisher</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/publisher/update.jsp'/>" target="body">Update Publisher</a>&nbsp;&nbsp;
  <a href="<c:url value='/jsps/publisher/delete.jsp'/>" target="body">Delete Publisher</a>&nbsp;&nbsp;

  </body>
</html>
