<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/4/2023
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UsersServlet">Tro ve danh sach</a>
<c:if test="${mess!=null}">
    <c:out value="${mess}"/>
</c:if>
<form action="/UsersServlet?action=create" method="post">
    <label for="name">Name: </label>
    <input type="text" name="name" id="name">
    <label for="email">Email: </label>
    <input type="text" name="email" id="email">
    <label for="country">Country: </label>
    <input type="text" name="country" id="country">
    <input type="submit" value="submit">
</form>
</body>
</html>
