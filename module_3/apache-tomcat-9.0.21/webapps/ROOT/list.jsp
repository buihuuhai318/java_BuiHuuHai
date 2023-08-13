<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/9/2023
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
</head>
<body>
<c:set var="dateString" value=""/>
<%--ngay--%>
<fmt:parseDate value="" var="date" pattern="yyyy-MM-dd"/>
<td class="data-list">
    <fmt:formatDate value="" pattern="dd/MM/yyyy"/>
</td>

<%--tiền--%>
<fmt:setLocale value="vi_VN"/>
<c:set var="price" value=""/>
<td class="data-list">
    <fmt:formatNumber value="" type="currency" currencySymbol="₫"/>
</td>


<div class="row">
    <button type="button" class="btn btn-primary" style="width: 10%; margin: 2%"
            onclick="window.location.href='/BaiHocServlet?action=create'">Create New
    </button>

</div>
<div class="row">
    <table id="example" class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tiêu Đề</th>
            <th scope="col">Loại Bài Học</th>
            <th scope="col">Độ Khó</th>
            <th scope="col">Link</th>
            <th scope="col">Module</th>
            <th scope="col">Sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${baiHocList}" var="baiHoc">
            <tr>
                <th scope="row">${baiHoc.id}</th>
                <td>${baiHoc.tieuDe}</td>
                <td>${baiHoc.getLoaiBaiHoc().getName()}</td>
                <td>${baiHoc.getDoKho().getName()}</td>
                <td><a href="${baiHoc.link}">link</a></td>
                <td>${baiHoc.getModule().getName()}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="window.location.href='/BaiHocServlet?action=edit&id=${baiHoc.id}'">Edit</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                             onclick="window.location.href='/BaiHocServlet?action=delete&id=${baiHoc.id}'">delete
                    </button>
                </td>
            </tr>
<%--            <div class="modal fade" id="exampleModal${baiHoc.id}" tabindex="-1" aria-labelledby="exampleModalLabel"--%>
<%--                 aria-hidden="true">--%>
<%--                <div class="modal-dialog">--%>
<%--                    <div class="modal-content">--%>
<%--                        <div class="modal-header">--%>
<%--                            <h1 class="modal-title fs-5" id="exampleModalLabel">Delete "${baiHoc.name}" ?</h1>--%>
<%--                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                        </div>--%>
<%--                        <div class="modal-body">--%>
<%--                            ban co muon xoa: ${baiHoc.name}--%>
<%--                        </div>--%>
<%--                        <div class="modal-footer">--%>
<%--                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                            <a href="/BaihocServlet?action=delete&id=${baiHoc.id}">--%>
<%--                                <button type="button" class="btn btn-danger">Delete</button>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </c:forEach>
        </tbody>
    </table>
</div>



</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script>
    new DataTable('#example');

    function showModal(code) {
        document.getElementById("idDelete").innerText = code;
        document.getElementById("code").value = code;
        $("#deleteModal").modal("show");
    }
</script>
</html>
