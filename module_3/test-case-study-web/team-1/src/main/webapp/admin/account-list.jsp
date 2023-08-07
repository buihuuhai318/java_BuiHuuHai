<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Manager</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="nav.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="header.jsp"></jsp:include>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <div class="row">
                            <div class="col-sm-3">
                                <h1 class="h3 mb-2 text-gray-800">Accounts Info</h1>
                            </div>
                            <c:if test="${sessionScope.get('role') == 1}">
                                <div class="col-sm-9">
                                    <a href="/AccountServlet?action=createNew" style="width: 20%; margin-left: auto"
                                       class="btn btn-primary btn-block">Create New Account</a>
                                </div>
                            </c:if>
                        </div>
                    </div>


                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Email</th>
                                    <th>Create</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <c:if test="${sessionScope.get('role') == 1}">
                                    <th>Action</th>
                                    </c:if>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${accountsList}" var="account1">
                                    <tr>
                                        <td>${account1.username}</td>
                                        <td>${account1.email}</td>
                                        <td>${account1.createDate}</td>
                                        <td>
                                            <c:if test="${account1.role.getId() == 1}">Admin</c:if>
                                            <c:if test="${account1.role.getId() == 2}">Employee</c:if>
                                            <c:if test="${account1.role.getId() == 3}">Customer</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${account1.isAvailable() == 0}">Available</c:if>
                                            <c:if test="${account1.isAvailable() == 1}"><p style="color: red">Not Available</p></c:if>
                                        </td>
                                        <c:if test="${sessionScope.get('role') == 1}">
                                            <td>
                                                <a href="/AccountServlet?action=edit&id=${account1.getId()}"
                                                   class="btn btn-info btn-circle"
                                                   style="margin-left: 8%; margin-bottom: 4%">
                                                    <i class="fas fa-user-edit"></i>
                                                </a>
                                                <a href="#" class="btn btn-danger btn-circle"
                                                   data-target="#delete${account1.getId()}" data-toggle="modal" style="margin-left: 8%">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </c:if>
                                    </tr>
                                    <div class="modal fade" id="delete${account1.getId()}" tabindex="-1" role="dialog"
                                         aria-labelledby="deleteLabel${account1.getId()}"
                                         aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="deleteLabel${account1.getId()}">Sure to
                                                        delete?</h5>
                                                    <button class="close" type="button" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">×</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">Delete Account: ${account1.username}</div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" type="button"
                                                            data-dismiss="modal">Cancel
                                                    </button>
                                                    <a class="btn btn-danger"
                                                       href="/AccountServlet?action=delete&id=${account1.getId()}">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; C0423G1 - Team 1</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>

</body>

</html>