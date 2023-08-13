<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 05/08/2023
  Time: 11:29
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
    <button type="button" class="btn btn-primary" style="width: 10%; margin: 2%" onclick="window.location.href='/ReportServlet?action=create'">Create New</button>
    <button type="button" class="btn btn-primary" style="width: 10%; margin: 2%" onclick="window.location.href='/RepostServlet?action=create'">Create New</button>

</div>
<div class="row">
    <table class="table" id="123">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên</th>
            <th scope="col">Hình Thức</th>
            <th scope="col">Ngày</th>
            <th scope="col">Số Tiền</th>
            <th scope="col">Ghi Chú</th>
            <th scope="col">Sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="report">
            <tr>
                <th scope="row">${report.id}</th>
                <td>${report.name}</td>
                <td>${report.getReceiptForm().getName()}</td>
                <td>${report.date}</td>
                <td>${report.cost}</td>
                <td>${report.note}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="window.location.href='/ReportServlet?action=edit&id=${report.id}'">Edit</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#exampleModal${report.id}">delete
                    </button>
                </td>
            </tr>
            <div class="modal fade" id="exampleModal${report.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Delete "${report.name}" ?</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            ban co muon xoa: ${report.name}
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <a href="/ReportServlet?action=delete&id=${report.id}">
                                <button type="button" class="btn btn-danger">Delete</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Button trigger modal -->


<!-- Modal -->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script>
    new DataTable('#123');
</script>
</body>
</html>
