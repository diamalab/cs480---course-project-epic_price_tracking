<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Publisher</title>
    
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
  <h1>Update Publisher:</h1>


	<form action="<c:url value='/updatePublisher'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
		<div class="form-group">
			<label for="epic-publisher-id">Publisher ID</label>
			<input id="epic-publisher-id" class="form-control" required type="text" name="id" value="${form.id }"/>
			<span style="color: red; font-weight: 900">${errors.id}</span>
		</div>
		<div class="form-group">
			<label for="epic-publisher-name">Publisher name</label>
			<input id="epic-publisher-name" class="form-control" required type="text" name="publisherName" value="${form.publisherName }"/>
			<span style="color: red; font-weight: 900">${errors.publisherName}</span>
		</div>
		<input type="submit" class="btn btn-primary" value="Update publisher"/>
		<a class="btn btn-secondary" href="<c:url value='/jsps/publisher/crud_publisher.jsp'/>" target="body">Cancel</a>
	</form>

  </body>
</html>
