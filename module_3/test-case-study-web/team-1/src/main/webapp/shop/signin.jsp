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
    <title></title>

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
            top: 0px;
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
            border: 16px solid #f3f3f3;
            border-top: 16px solid black;
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
                        <img src="images/logo/logo.jpg" style="width: 70%" alt="">
                    </a>
                    <h2 class="text-center" style="margin: 3%">Create Your Account</h2>
                    <form class="text-left clearfix" action="/AccountServlet?action=create" method="post">
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Email" name="email" value="${email}" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Username" name="username" value="${username}" required maxlength="20" minlength="6">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password" name="password" required maxlength="20" minlength="6">
                        </div>
                        <c:if test='${requestScope["mess"] != null}'>
                            <div class="alert alert-danger alert-common" role="alert"><i class="tf-ion-close-circled"></i><span>Warning!</span> Email or username already existed !!!</div>
                        </c:if>
                        <div class="text-center">
                            <button type="submit" class="spinner-button btn btn-main text-center">Sign In</button>
                        </div>
                    </form>
                    <p class="mt-20">Already hava an account ?<a href="/AccountServlet?action=login" class="spinner-link"> Login</a></p>
                    <p><a href="/AccountServlet?action=res" class="spinner-link"> Forgot your password?</a></p>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="loader-overlay" id="spinnerOverlay">
    <div class="loader"></div>
</div>
<!--
Essential Scripts
=====================================-->


<script>
    const spinnerButtons = document.querySelectorAll('.spinner-button');
    const spinnerLinks = document.querySelectorAll('.spinner-link');
    const spinnerOverlay = document.getElementById('spinnerOverlay');

    spinnerButtons.forEach(button => {
        button.addEventListener('click', function() {
            showSpinnerOverlay();
        });
    });

    spinnerLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            showSpinnerOverlay();
        });
    });

    function showSpinnerOverlay() {
        spinnerOverlay.style.display = 'flex'; // Hiển thị spinner overlay
        setTimeout(() => {
            spinnerOverlay.style.display = 'none'; // Ẩn spinner overlay sau 2 giây
        }, 3000);
    }
</script>

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