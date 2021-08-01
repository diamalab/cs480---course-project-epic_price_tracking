<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
</head>
<body>
<div>
    <table class="table" align="center">
        <tr>
            <th>name</th>
            <th>email</th>
        </tr>
        <c:forEach items="${UserList}" var="user">
            <tr>
                <td>${user.username }</td>
                <td>${user.email }</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>