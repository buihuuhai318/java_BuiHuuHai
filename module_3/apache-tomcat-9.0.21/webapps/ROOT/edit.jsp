<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/8/2023
  Time: 1:55 PM
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
    <h2 align="center">edit</h2>
    <form action="/BaiHocServlet?action=edit&id=${baiHoc.id}" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Tieu De</label>
            <input type="text" class="form-control" id="exampleInputEmail1" value="${baiHoc.tieuDe}" name="tieuDe">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Link</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="link" value="${baiHoc.link}">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <select class="form-select" aria-label="Default select example" name="loaiBaiHoc">

                <c:forEach var="loai" items="${loaiBaiHoc}">
                    <option value="${loai.id}"
                            <c:if test="${loai.id == baiHoc.getLoaiBaiHoc().getId()}">
                                selected
                            </c:if>
                    >${loai.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <select class="form-select" aria-label="Default select example" name="doKho">
                <c:forEach var="doKho" items="${doKho}">
                    <option value="${doKho.id}"
                            <c:if test="${doKho.id == baiHoc.getDoKho().getId()}">
                                selected
                            </c:if>
                    >${doKho.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <select class="form-select" aria-label="Default select example" name="module">
                <c:forEach var="module" items="${module}">
                    <option value="${module.id}"
                            <c:if test="${module.id == baiHoc.getModule().getId()}">
                                selected
                            </c:if>
                    >${module.name}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
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
