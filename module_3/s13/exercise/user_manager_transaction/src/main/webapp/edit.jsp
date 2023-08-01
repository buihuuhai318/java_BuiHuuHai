<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/5/2023
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UsersServlet">tro ve </a>
<c:if test="${mess!=null}">
    <c:out value="${mess}"/>
</c:if>
<form action="/UsersServlet?action=edit&id=${id}" method="post">
    <fieldset>
        <legend>Sua thong tin</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${users.getName()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" value="${users.getEmail()}"></td>
            </tr>
            <tr>
                <td>Country: </td>
                <td><input type="text" name="country" id="country" value="${users.getCountry()}"></td>
            </tr>
            <tr>
                <td></td>
                <td> <input type="submit" value="edit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
