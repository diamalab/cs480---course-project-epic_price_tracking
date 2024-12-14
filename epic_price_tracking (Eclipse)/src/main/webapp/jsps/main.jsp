<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>main</title>
    
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
	<style type="text/css">
		iframe {
			width: 100%;
			height: 100%;
		}
	</style>
  </head>
  
  <body>
<div style="display: flex; flex-direction: column; height:100%">
	<div style="max-height:60px">
		<iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
	</div>
	<div style="padding-top: 20px;  height:100%">
	
		<iframe frameborder="0" src="<c:url value='/jsps/body.jsp'/>" name="body"></iframe>
	
	</div>
</div>
  </body>
</html>
