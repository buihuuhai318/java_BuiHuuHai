<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 09/08/2023
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
</head>
<body>
<div class="row">
    <form action="/ReportServlet?action=create" method="post">
        <input type="text" value="${reportBoard.name}" name="name">
        <select name="receipt">
            <c:forEach var="receipt" items="${formList}">
                <option value="${receipt.id}">${receipt.name}</option>
            </c:forEach>
        </select>
        <input type="date" name="date">
        <input type="number" name="amount">
        <input type="text" name="note">
        <button type="submit" class="btn btn-success">Create</button>
        <button type="button" class="btn btn-success" onclick="window.location.href='/ReportServlet'">Back</button>
    </form>
</div>
</body>
</html>
