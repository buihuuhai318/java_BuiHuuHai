<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/8/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css">
</head>
<body>
<div class="container">
  <h2 align="center">Information You Want To Search For</h2>
  <form action="" method="post">
    <label for="name">nhap ten muon tiem</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="tim kiem">
    <table border="1" cellpadding="5" align="center" class="table table-dark table-striped">
      <tr>
        <td>Name</td>
        <td>point</td>
        <td>Rank</td>
        <td>Id Card</td>
        <td>Name Class</td>
      </tr>

    </table>
  </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js"></script>
<script>
  new DataTable('#example');

  function showModal(code) {
    document.getElementById("idDelete").innerText = code;
    document.getElementById("code").value = code;
    $("#deleteModal").modal("show");
  }
</script>
</html>
