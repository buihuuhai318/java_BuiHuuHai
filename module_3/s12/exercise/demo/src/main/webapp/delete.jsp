<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/5/2023
  Time: 8:45 AM
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
<form  method="post" action="/UserServlet?action=delete&id=${users.id}">
    <h3>Ban co chac xoa khong</h3>
    <fieldset>
        <legend>Thong tin san pham muon xoa</legend>
        <table>
           <tr>
               <td>Name: </td>
               <td>${users.getName()}</td>
           </tr>
            <tr>
                <td>Email: </td>
                <td>${users.getEmail()}</td>
            </tr>
            <tr>
                <td>Country</td>
                <td>${users.getCountry()}</td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="delete">
                </td>
                <td>

                    <a href="/UserServlet"></a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
