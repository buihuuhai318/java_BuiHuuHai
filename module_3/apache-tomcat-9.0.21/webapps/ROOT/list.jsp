<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/4/2023
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UsersServlet?action=create">Them moi</a>
<a href="/UsersServlet?action=findCountry">Timkiem theo country</a>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Email</td>
    <td>Country</td>
  </tr>
  <c:forEach var="user" items="${usersList}">
    <tr>
      <td><c:out value="${user.id}"/></td>
      <td><c:out value="${user.name}"/></td>
      <td><c:out value="${user.email}"/></td>
      <td><c:out value="${user.country}"/></td>
      <td><a href="/UsersServlet?action=delete&id=${user.id}">Xoa</a></td>
      <td><a href="/UsersServlet?action=edit&id=${user.id}">Sua</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
