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
<a href="/UserServlet?action=create">Them moi</a>
<a href="/UserServlet?action=findCountry">Tim kiem theo country</a>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Email</td>
    <td>Country</td>
  </tr>
  <c:forEach var="users" items="${userList}">
    <tr>
      <td><c:out value="${users.id}"/></td>
      <td><c:out value="${users.name}"/></td>
      <td><c:out value="${users.email}"/></td>
      <td><c:out value="${users.country}"/></td>
      <td><a href="/UserServlet?action=delete&id=${users.id}">Xoa</a></td>
      <td><a href="/UserServlet?action=edit&id=${users.id}">Sua</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
