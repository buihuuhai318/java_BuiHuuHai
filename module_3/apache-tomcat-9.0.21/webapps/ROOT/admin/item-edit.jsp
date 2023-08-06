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
            <div class="card o-hidden border-0 shadow-lg my-5" style="padding: 5%">

                <form class="user" action="ItemServlet?action=edit&id=${requestScope["items"].getId()}" method="post">
                    <div class="text-center" style="width: 20%; margin-left: auto; margin-right: auto">
                        <fieldset disabled>
                            <div class="form-group">
                                <label class="text-xs font-weight-bold text-primary text-uppercase mb-1">Item ID</label>
                                <input type="text" class="form-control"
                                       placeholder="ID" value="${requestScope["items"].getId()}"
                                       name="id" style="text-align: center">
                            </div>
                        </fieldset>
                    </div>
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-5" style="padding: 2%">
                                <div class="row">
                                    <c:forEach items="${imageList}" var="image">
                                        <img class="card-img col-sm-6" style="width: 20%; margin-top: 5%"
                                             src="item-image/${requestScope["items"].getItemType().getName()}/${image.getUrl()}"
                                             alt="">
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="col-lg-7">
                                <div class="p-5">
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Name</p>
                                            <input type="text" class="form-control"
                                                   placeholder="Name" value="${requestScope["items"].getName()}"
                                                   name="name" required maxlength="50">
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Code</p>
                                            <input type="text" class="form-control"
                                                   placeholder="Code" value="${requestScope["items"].getCode()}"
                                                   name="code" required maxlength="50">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Price</p>
                                            <input type="text" class="form-control"
                                                   placeholder="Price" value="${requestScope["items"].getPrice()}"
                                                   name="price" required min="0" max="1000000">

                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Inventory</p>
                                            <input type="text" class="form-control"
                                                   placeholder="Inventory"
                                                   value="${requestScope["items"].getInventory()}"
                                                   name="inventory" required min="0" max="1000000">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Type</p>
                                            <select class="user-select-auto form-control" name="type">
                                                <c:forEach items="${itemTypeList}" var="types">
                                                    <option value="${types.getId()}"
                                                            <c:if test='${types.getId() eq requestScope["items"].getItemType().getId()}'>selected</c:if> > ${types.getName()} </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Available</p>
                                            <select class="user-select-auto form-control" name="available">
                                                <option value="1"
                                                        <c:if test='${requestScope["items"].getAvailable() eq "1"}'>selected</c:if> >
                                                    Not Available
                                                </option>
                                                <option value="0"
                                                        <c:if test='${requestScope["items"].getAvailable() eq "0"}'>selected</c:if> >
                                                    Available
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Description</p>
                                        <input type="text" class="form-control"
                                               placeholder="Description" value="${requestScope["items"].getDescription()}"
                                               name="description" required maxlength="200">
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">Image 1
                                                + 3</p>
                                            <input type="file" class="form-control" name="image1"
                                                   style="height: fit-content; margin-bottom: 5%" maxlength="100">
                                            <input type="file" class="form-control" name="image4"
                                                   style="height: fit-content" maxlength="100">
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="text-xs font-weight-bold text-primary text-uppercase mb-1">Image 2
                                                + 4</p>
                                            <input type="file" class="form-control" name="image2"
                                                   style="height: fit-content; margin-bottom: 5%" maxlength="100">
                                            <input type="file" class="form-control" name="image4"
                                                   style="height: fit-content" maxlength="100">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <button class="btn btn-success btn-user btn-block" type="submit">Update</button>
                        <a href="/ItemServlet?action=list" class="btn btn-google btn-user btn-block">
                            Cancel
                        </a>
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