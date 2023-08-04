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

    <title>SB Admin 2 - Tables</title>

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
            <div class="card o-hidden border-0 shadow-lg my-5"
                 style="padding: 5%; width: 50%; margin-left: auto; margin-right: auto ">
                <form class="user" action="AccountServlet?action=createNew" method="post">
                    <div class="text-center" style="width: 50%; margin-left: auto; margin-right: auto">

                        <div class="form-group">
                            <label class="font-weight-bold text-primary text-uppercase mb-1">Create New
                                Account</label>
                        </div>

                    </div>

                    <div class="text-center">
                        <c:if test='${requestScope["fail"] != null}'>
                            <div class="alert alert-danger alert-common" role="alert" style="text-align: center; width: 80%; margin-left: auto; margin-right: auto"><i
                                    class="tf-ion-close-circled"></i><span>Warning!</span> Email hoặc Username đã tồn
                                tại !!!
                            </div>
                        </c:if>
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1"
                                           style="text-align: left">Email</p>
                                        <input type="email" class="form-control"
                                               placeholder="Email" name="email">
                                    </div>
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1"
                                           style="text-align: left">Username</p>
                                        <input type="text" class="form-control"
                                               placeholder="Username" name="username">
                                    </div>
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1"
                                           style="text-align: left">Password</p>
                                        <input type="text" class="form-control"
                                               placeholder="Password" name="password">
                                    </div>
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1"
                                           style="text-align: left">
                                            Role</p>
                                        <select class="user-select-auto form-control" name="roleId">
                                            <c:forEach items="${rolesList}" var="roles">
                                                <option value="${roles.getId()}"> ${roles.getName()} </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <button class="btn btn-success btn-user btn-block" type="submit">Create</button>
                        <a href="AccountServlet?action=list" class="btn btn-google btn-user btn-block">Cancel</a>
                    </div>
                </form>
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