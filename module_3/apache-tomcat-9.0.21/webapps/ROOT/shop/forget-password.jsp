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

<section class="forget-password-page account">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="block text-center">
                    <a class="logo" href="/ShopServlet">
                        <img src="images/logo/logo.jpg" style="width: 70%;" alt="">
                    </a>
                    <h2 class="text-center">Welcome Back</h2>
                    <form action="/AccountServlet?action=res" method="post" class="text-left clearfix">
                        <p>Please enter the email address for your account. A verification code will be sent to you.
                            Once you have received the verification code, you will be able to choose a new password for
                            your account.</p>
                        <div class="form-group">
                            <input type="email" class="form-control" id="exampleInputEmail1"
                                   placeholder="Account email address" name="email">
                        </div>
                        <c:if test='${requestScope["mess"] != null}'>
                            <div class="alert alert-danger alert-common" role="alert">
                                <i class="tf-ion-close-circled"></i>
                                <span>Warning!</span> Email không tồn tại !!!
                            </div>
                        </c:if>
                        <c:if test='${requestScope["done"] != null}'>
                            <div class="alert alert-success alert-common" role="alert">
                                <i class="tf-ion-thumbsup"></i>
                                <span>Well done!</span> Mật khẩu mới đã được gửi qua mail của bạn !!!
                            </div>
                        </c:if>
                        <div class="text-center">
                            <button type="submit" class="btn btn-main text-center">Request password reset</button>
                        </div>
                    </form>
                    <p class="mt-20"><a href="/AccountServlet?action=login">Back to log in</a></p>
                </div>
            </div>
        </div>
    </div>
</section>

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

<!-- Main Js File -->
<script src="js/script.js"></script>


</body>
</html>