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
    <title>Aviato | E-commerce template</title>

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

<div class="page-wrapper">
    <div class="checkout shopping">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="block billing-details">
                        <h4 class="widget-title">Change Password</h4>
                        <form class="checkout-form" action="AccountServlet?action=change" method="post">
                            <div class="form-group">
                                <label for="full_name">Old Password</label>
                                <input type="password" class="form-control" id="full_name" placeholder="" name="old-pass">
                            </div>
                            <div class="form-group">
                                <label for="user_address">New Password</label>
                                <input type="password" class="form-control" id="user_address" placeholder=""
                                       name="new-pass">
                            </div>
                            <div class="form-group">
                                <label for="user_country">Confirm</label>
                                <input type="password" class="form-control" id="user_country" placeholder=""
                                       name="confirm-pass">
                            </div>
                            <c:if test='${requestScope["done"] != null}'>
                                <div class="alert alert-success alert-common" role="alert">
                                    <i class="tf-ion-thumbsup"></i>
                                    <span>Well done!</span> Đổi mật khẩu thành công !!!</div>
                            </c:if>
                            <c:if test='${requestScope["pass"] != null}'>
                                <div class="alert alert-danger alert-common" role="alert">
                                    <i class="tf-ion-close-circled"></i>
                                    <span>Warning!</span> Mật khẩu mới không trùng khớp !!!
                                </div>
                            </c:if>
                            <c:if test='${requestScope["fail"] != null}'>
                                <div class="alert alert-danger alert-common" role="alert">
                                    <i class="tf-ion-close-circled"></i>
                                    <span>Warning!</span> Mật khẩu không đúng !!!
                                </div>
                            </c:if>
                            <div class="form-group" style="margin-top: 3%">
                                <button type="submit" class="btn btn-main text-center btn-primary" id="liveToastBtn">Change
                                    Password
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


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