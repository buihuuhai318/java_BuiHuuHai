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
    <link href="../css/sb-admin-2.min.css" rel="stylesheet">

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

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Bill Info</h1>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Bill ID</th>
                                    <th>Date</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Payment</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Bill ID</th>
                                    <th>Date</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Payment</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${listBill}" var="bill">
                                    <tr>
                                        <td>${bill.id}</td>
                                        <td>${bill.date}</td>
                                        <td>${bill.totalQuantity}</td>
                                        <td>${bill.totalPrice}</td>
                                        <td>${bill.getPaymentMethod().getName()}</td>
                                        <td>
                                            <c:if test="${bill.getPaymentStatus() == 1}">Purchased</c:if>
                                            <c:if test="${bill.getPaymentStatus() == 0}"><p style="color: red">Not
                                                Purchased</p></c:if>
                                        </td>
                                        <td>
                                            <a href="/AdminServlet?action=showCart&idCart=${bill.cart}"
                                               class="btn btn-info btn-circle"
                                               style="margin-left: 8%; margin-bottom: 4%">
                                                <i class="fas fa-user-check"></i>
                                            </a>
                                            <c:if test="${sessionScope.get('role') == 1}">
                                            <a href="#" class="btn btn-success btn-circle"
                                               data-target="#delete${bill.id}" data-toggle="modal"
                                               style="margin-left: 8%">
                                                <i class="fas fa-angle-down"></i>
                                            </a>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="delete${bill.id}" tabindex="-1" role="dialog"
                                         aria-labelledby="deleteLabel${bill.id}"
                                         aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="deleteLabel${bill.id}">Sure to
                                                        change?</h5>
                                                    <button class="close" type="button" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">×</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">Change Payment Status - Bill
                                                    ID: ${bill.id}</div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" type="button"
                                                            data-dismiss="modal">Cancel
                                                    </button>
                                                    <c:if test="${bill.getPaymentStatus() == 1}"><a
                                                            class="btn btn-danger"
                                                            href="/AdminServlet?action=purchased&idBill=${bill.id}&billStatus=${bill.getPaymentStatus()}">
                                                        Not Purchased
                                                    </a></c:if>
                                                    <c:if test="${bill.getPaymentStatus() == 0}"><a
                                                            class="btn btn-success"
                                                            href="/AdminServlet?action=purchased&idBill=${bill.id}&billStatus=${bill.getPaymentStatus()}">
                                                        Purchased
                                                    </a></c:if>
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
            <!-- /.container-fluid -->
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

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>

</body>

</html>