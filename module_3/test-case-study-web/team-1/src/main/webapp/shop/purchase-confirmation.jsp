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
    <title>#Thehome - Purchase confirmation</title>

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

</head>

<body id="body">

<!-- Start Top Header Bar -->
<jsp:include page="header-bar.jsp"></jsp:include>

<section class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="content">
                    <h1 class="page-name">Purchase Confirmation</h1>
                    <ol class="breadcrumb">
                        <li><a href="/ShopServlet">Home</a></li>
                        <li class="active">purchase confirmation</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="page-wrapper success-msg">
    <div class="container" style="margin-bottom: 5%">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="block text-center">
                    <i class="tf-ion-android-checkmark-circle" style="margin: 0"></i>
                    <c:if test="${COD == null}">
                        <h2 class="text-center">Payment Successfully !!!</h2>
                    </c:if>
                    <c:if test="${COD != null}">
                        <h2 class="text-center">Your Order Is On The Way !!!</h2>

                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <div style="margin-top: 0; padding-top: 0">
        <div class="purchase-confirmation shopping">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="block ">
                            <div class="purchase-confirmation-details">
                                <table id="purchase-receipt" class="table">
                                    <thead>
                                    <tr>
                                        <th><strong>Payment:</strong></th>
                                        <th>${cart.getId()}</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td class=""><strong>Payment Status:</strong></td>
                                        <c:if test="${COD == null}">
                                            <td class="success-msg" style="color: #1cc88a">Complete</td>
                                        </c:if>
                                        <c:if test="${COD != null}">
                                            <td class="success-msg" style="color: #1cc88a">COD</td>
                                        </c:if>

                                    </tr>
                                    <tr>
                                        <td><strong>Payment Method:</strong></td>
                                        <td>${bill.getPaymentMethod().getName()}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Phone:</strong></td>
                                        <td>${bill.getPhone()}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Address:</strong></td>
                                        <td>${bill.getAddress()}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Date:</strong></td>
                                        <td>${cart.getPaymentDate()}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Total Price:</strong></td>
                                        <td>$${bill.getTotalPrice()}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="block text-center">
                        <div class="col-md-8 col-md-offset-2">
                        <a href="/ShopServlet" class="btn btn-main mt-20" style="margin-left: auto; margin-right: auto; margin-top: 10%">Shopping.....</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section><!-- /.page-warpper -->





<jsp:include page="footer-bar.jsp"></jsp:include>

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


</body>
</html>
