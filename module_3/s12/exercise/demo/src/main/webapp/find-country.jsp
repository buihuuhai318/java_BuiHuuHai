<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/4/2023
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UserServlet">Tro ve danh sach</a>
<c:if test="${mess!=null}">
  <c:out value="${mess}"/>
</c:if>
<form action="/UserServlet?action=findCountry" method="post">
<label for="country">Nhap quoc gia muon tim</label>
  <input type="text" name="country" id="country">
  <input type="submit" value="tim kiem">
  <table>
    <tr>
      <td>Ten</td>
      <td>Email</td>
      <td>country</td>
    </tr>
    <c:forEach var="c" items="${userList}">
      <tr>
      <td><c:out value="${c.name}"/> </td>
      <td><c:out value="${c.email}"/> </td>
      <td><c:out value="${c.country}"/> </td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
