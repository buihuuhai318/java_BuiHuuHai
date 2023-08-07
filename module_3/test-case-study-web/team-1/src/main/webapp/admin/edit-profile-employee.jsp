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
            <div class="card o-hidden border-0 shadow-lg my-5" style="padding: 5%">

                <form class="user" action="/EmployeeServlet?action=editList&id=${requestScope["employees"].getId()}" method="post">
                    <div class="text-center" style="width: 20%; margin-left: auto; margin-right: auto">
                        <fieldset disabled>
                            <div class="form-group">
                                <label class="font-weight-bold text-primary text-uppercase mb-1">Edit Employee</label>
                            </div>
                        </fieldset>
                    </div>
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-5" style="padding: 2%">
                                <img class="card-img" src="image-customers/${requestScope["employees"].getImage()}"
                                     alt="">
                                <input type="file" class="form-control" id=""
                                       placeholder="image" value="${requestScope["employees"].getImage()}"
                                       style="margin-top: 5%; height: fit-content" name="image">
                            </div>
                            <div class="col-lg-7">
                                <div class="p-5">
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">Name</p>
                                        <input type="text" class="form-control"
                                               placeholder="Name" value="${requestScope["employees"].getName()}"
                                               name="name" required maxlength="50">
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <div class="form-group">
                                                <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">Salary</p>
                                                <input type="text" class="form-control"
                                                       placeholder="Salary" value="${requestScope["employees"].getSalary()}"
                                                       name="salary" required min="0" max="100000000">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Gender</p>
                                            <select class="user-select-auto form-control" name="gender">
                                                <option value="1"
                                                        <c:if test='${requestScope["employees"].getGender() eq "1"}'>selected</c:if> >
                                                    Male
                                                </option>
                                                <option value="0"
                                                        <c:if test='${requestScope["employees"].getGender() eq "0"}'>selected</c:if> >
                                                    Female
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Birthday</p>
                                            <input type="date" class="form-control"
                                                   placeholder="Birthday" value="${requestScope["employees"].getBirthday()}"
                                                   name="birthday" required>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Available</p>
                                            <select class="user-select-auto form-control" name="available">
                                                <option value="1"
                                                        <c:if test='${requestScope["employees"].getStatus() eq "1"}'>selected</c:if> >
                                                    Not Available
                                                </option>
                                                <option value="0"
                                                        <c:if test='${requestScope["employees"].getStatus() eq "0"}'>selected</c:if> >
                                                    Available
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">Phone</p>
                                        <input type="text" class="form-control"
                                               placeholder="Phone" value="${requestScope["employees"].getPhone()}"
                                               name="phone" required maxlength="50">
                                    </div>
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">Address</p>
                                        <input type="text" class="form-control"
                                               placeholder="Address" value="${requestScope["employees"].getAddress()}"
                                               name="address" required maxlength="100">
                                    </div>
                                    <hr>
                                    <div style="width: 80%; margin-left: auto; margin-right: auto" class="row form-group">
                                        <div class="col-sm-6">
                                            <button class="btn btn-primary btn-user btn-block" type="submit">Update</button>
                                        </div>
                                        <div class="col-sm-6">
                                            <a href="/EmployeeServlet?action=list" class="btn btn-google btn-user btn-block">
                                                Cancel
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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