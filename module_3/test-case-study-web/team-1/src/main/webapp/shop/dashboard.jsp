<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<!--
// WEBSITE: https://themefisher.com
// TWITTER: https://twitter.com/themefisher
// FACEBOOK: https://www.facebook.com/themefisher
// GITHUB: https://github.com/themefisher/
-->

<html lang="en">
<head>

    <!-- Basic Page Needs
    ================================================== -->
    <meta charset="utf-8">
    <title>#Thehome - Dashboard</title>

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Construction Html5 Template">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
    <meta name="author" content="Themefisher">
    <meta name="generator" content="Themefisher Constra HTML Template v1.0">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>

    <!-- Themefisher Icon font -->
    <link rel="stylesheet" href="plugins/themefisher-font/style.css">
    <!-- bootstrap.min css -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">

    <!-- Animate css -->
    <link rel="stylesheet" href="plugins/animate/animate.css">
    <!-- Slick Carousel -->
    <link rel="stylesheet" href="plugins/slick/slick.css">
    <link rel="stylesheet" href="plugins/slick/slick-theme.css">

    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

</head>

<body id="body">

<!-- Start Top Header Bar -->
<jsp:include page="header-bar.jsp"></jsp:include>

<section class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="content">
                    <h1 class="page-name">Dashboard</h1>
                    <ol class="breadcrumb">
                        <li><a href="/ShopServlet">Home</a></li>
                        <li class="active">my account</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="user-dashboard page-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="list-inline dashboard-menu text-center">
                    <li><a class="active" href="/CustomerServlet?action=showBill">Dashboard</a></li>
                    <li><a href="/CustomerServlet">Profile Details</a></li>
                </ul>
                <div class="dashboard-wrapper user-dashboard">
                    <div class="total-order mt-20">
                        <h4>Total Orders</h4>
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable">
                                <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Quantity</th>
                                    <th>Payment Method</th>
                                    <th>Total</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listBill}" var="bill">
                                    <tr>
                                        <td>
                                            <a href="/CustomerServlet?action=showCartDetail&idCart=${bill.getCart()}">${bill.getDate()}</a>
                                        </td>
                                        <td>${bill.getTotalQuantity()}</td>
                                        <td>${bill.getPaymentMethod().getName()}</td>
                                        <td>$ ${bill.getTotalPrice()}</td>
                                        <td>
                                            <c:if test="${bill.getPaymentStatus() == 0}"><p style="color: orange">On Delivery</p></c:if>
                                            <c:if test="${bill.getPaymentStatus() == 1}"><p style="color: #01c501">Complete</p></c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<footer class="footer section text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="social-media">
                    <li>
                        <a href="https://www.facebook.com/themefisher">
                            <i class="tf-ion-social-facebook"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.instagram.com/themefisher">
                            <i class="tf-ion-social-instagram"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.twitter.com/themefisher">
                            <i class="tf-ion-social-twitter"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.pinterest.com/themefisher/">
                            <i class="tf-ion-social-pinterest"></i>
                        </a>
                    </li>
                </ul>
                <ul class="footer-menu text-uppercase">
                    <li>
                        <a href="contact.html">CONTACT</a>
                    </li>
                    <li>
                        <a href="shop.html">SHOP</a>
                    </li>
                    <li>
                        <a href="pricing.html">Pricing</a>
                    </li>
                    <li>
                        <a href="contact.html">PRIVACY POLICY</a>
                    </li>
                </ul>
                <p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a
                        href="https://themefisher.com/">Themefisher</a></p>
            </div>
        </div>
    </div>
</footer>

<!--
Essential Scripts
=====================================-->

<!-- Main jQuery -->
<script src="plugins/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.1 -->
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Bootstrap Touchpin -->
<script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
<!-- Instagram Feed Js -->
<script src="plugins/instafeed/instafeed.min.js"></script>
<!-- Video Lightbox Plugin -->
<script src="plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
<!-- Count Down Js -->
<script src="plugins/syo-timer/build/jquery.syotimer.min.js"></script>

<!-- slick Carousel -->
<script src="plugins/slick/slick.min.js"></script>
<script src="plugins/slick/slick-animation.min.js"></script>

<!-- Google Mapl -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
<script type="text/javascript" src="plugins/google-map/gmap.js"></script>

<!-- Main Js File -->
<script src="js/script.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script>
    new DataTable('#dataTable');
</script>

</body>
</html>