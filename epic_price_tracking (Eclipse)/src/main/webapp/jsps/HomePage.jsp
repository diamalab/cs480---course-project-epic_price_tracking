<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
	<script ><%@include file="/WEB-INF/lib/js/bootstrap.min.js"%></script>
	<script
			  src="https://code.jquery.com/jquery-3.6.0.slim.js"
			  integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
			  crossorigin="anonymous"></script>
</head>
<style>
iframe {
	width: 100%;
	height: 100%;
}
.root{
	display: flex;
	flex-driection: row;
	height: 100%;
}

body {
height: 100%

}

</style>
<body>
	<div class="root">
		<div style="flex:3">
			<iframe frameborder="0" src="<c:url value='/findAllgames'/>" name="content"></iframe>
		</div>
		<div style="flex:1">
			<iframe frameborder="0" src="<c:url value='/findGenrePublisher'/>" name="genreContent"></iframe>
		</div>
	</div>
</body>

</html>