<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 21/07/2023
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create new product</title>
  <style>
    .message {
      color: green;
    }
  </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/ProductServlet">Back to product list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name:</td>
        <td><label for="name"></label><input type="text" name="name" id="name"></td>
      </tr>
      <tr>
        <td>price:</td>
        <td><label for="price"></label><input type="text" name="price" id="price"></td>
      </tr>
      <tr>
        <td>describe:</td>
        <td><label for="describe"></label><input type="text" name="describe" id="describe"></td>
      </tr>
      <tr>
        <td>producer:</td>
        <td><label for="producer"></label><input type="text" name="producer" id="producer"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create Product"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
