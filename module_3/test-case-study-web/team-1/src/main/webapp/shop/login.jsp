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
    <title>#Thehome - Login</title>

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

    <style>
        .loader-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            justify-content: center;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 9999;
            display: none; /* Ẩn ban đầu */
        }

        /* CSS của spinner vẫn như trong ví dụ trước */

        @keyframes spin {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }

        .loader {
            border: 8px solid #f3f3f3;
            border-top: 8px solid black;
            border-radius: 50%;
            width: 120px;
            height: 120px;
            animation: spin 2s linear infinite;
        }
    </style>
</head>

<body id="body">

<section class="signin-page account">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="block text-center">
                    <a class="logo spinner-link" href="/ShopServlet">
                        <img src="images/logo/logo.jpg" style="width: 60%;" alt="">
                    </a>
                    <h2 class="text-center" style="margin: 3%">Welcome Back</h2>
                    <form class="text-left clearfix" action="/AccountServlet?action=login" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Username" name="username" value="${username}" maxlength="50">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password" name="password" value="${password}" maxlength="50">
                        </div>
                        <div class="btn-group" data-toggle="buttons" style="margin-left: auto">
                            <input type="checkbox" class="btn-check" style="margin-right: 5px; margin-left: 10px" id="btncheck1" name="rememberMe" checked>
                            Remember
                        </div>
                        <c:if test='${requestScope["mess"] != null}'>
                            <div class="alert alert-danger alert-common" role="alert" style="margin-top: 3%">
                                <i class="tf-ion-close-circled"></i>
                                <span>Warning!</span> Invalid username or password !!!
                            </div>
                        </c:if>
                        <div class="text-center" style="margin-top: 3%">
                            <button type="submit" id="showSpinnerButton1" onclick="showSpinner()" class="btn btn-main text-center">Login</button>
                        </div>
                    </form>
                    <p class="mt-20">New in this site ?<a href="/AccountServlet?action=create" id="showSpinnerButton2"> Create new account</a>
                    </p>
                    <p><a href="/AccountServlet?action=res" id="showSpinnerButton3"> Forgot your password?</a></p>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="loader-overlay" id="spinnerOverlay">
    <div class="loader"></div>
</div>

<script>
    function showSpinner() {
        let spinnerContainer = document.getElementById('spinnerOverlay');
        spinnerContainer.style.display = 'flex';
    }

    document.getElementById('showSpinnerButton1').addEventListener('click', showSpinner);
    document.getElementById('showSpinnerButton2').addEventListener('click', showSpinner);
    document.getElementById('showSpinnerButton3').addEventListener('click', showSpinner);
    document.getElementById('showSpinnerLink').addEventListener('click', function(e) {
        e.preventDefault();
        showSpinner();
    });
    document.getElementById('showSpinnerLink1').addEventListener('click', function(e) {
        e.preventDefault();
        showSpinner();
    });
</script>


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