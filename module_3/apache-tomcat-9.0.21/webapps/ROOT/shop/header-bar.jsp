<%@ page import="com.example.team1.model.accounts.Accounts" %>
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

    <!-- theme meta -->
    <meta name="theme-name" content="aviato"/>

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
<section class="top-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-xs-12 col-sm-4">
                <div class="contact-number">
                    <i class="tf-ion-ios-telephone"></i>
                    <span>0129- 12323-123123</span>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Site Logo -->
                <div class="logo text-center">
                    <a href="../index.jsp">
                        <!-- replace logo here -->
                        <svg width="135px" height="29px" viewBox="0 0 155 29" version="1.1"
                             xmlns="http://www.w3.org/2000/svg"
                             xmlns:xlink="http://www.w3.org/1999/xlink">
                            <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
                               font-family="AustinBold, Austin" font-weight="bold">
                                <g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
                                    <text id="AVIATO">
                                        <tspan x="108.94" y="325">
                                            <img src="images/logo/logo.jpg" style="width: 100%" alt="">
                                        </tspan>
                                    </text>
                                </g>
                            </g>
                        </svg>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Cart -->
                <ul class="top-menu text-right list-inline">
                    <li class="dropdown cart-nav dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
                                class="tf-ion-android-cart"></i>Cart</a>
                        <div class="dropdown-menu cart-dropdown">
                            <!-- Cart Item -->
                            <div class="media">
                                <a class="pull-left" href="#!">
                                    <img class="media-object" src="images/shop/cart/cart-1.jpg" alt="image"/>
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="#!">Ladies Bag</a></h4>
                                    <div class="cart-price">
                                        <span>1 x</span>
                                        <span>1250.00</span>
                                    </div>
                                    <h5><strong>$1200</strong></h5>
                                </div>
                                <a href="#!" class="remove"><i class="tf-ion-close"></i></a>
                            </div><!-- / Cart Item -->
                            <!-- Cart Item -->
                            <div class="media">
                                <a class="pull-left" href="#!">
                                    <img class="media-object" src="images/shop/cart/cart-2.jpg" alt="image"/>
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="#!">Ladies Bag</a></h4>
                                    <div class="cart-price">
                                        <span>1 x</span>
                                        <span>1250.00</span>
                                    </div>
                                    <h5><strong>$1200</strong></h5>
                                </div>
                                <a href="#!" class="remove"><i class="tf-ion-close"></i></a>
                            </div><!-- / Cart Item -->

                            <div class="cart-summary">
                                <span>Total</span>
                                <span class="total-price">$1799.00</span>
                            </div>
                            <ul class="text-center cart-buttons">
                                <li><a href="cart.html" class="btn btn-small">View Cart</a></li>
                                <li><a href="checkout.html" class="btn btn-small btn-solid-border">Checkout</a></li>
                            </ul>
                        </div>

                    </li><!-- / Cart -->

                    <!-- Search -->
                    <li class="dropdown search dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
                                class="tf-ion-ios-search-strong"></i> Search</a>
                        <ul class="dropdown-menu search-dropdown">
                            <li>
                                <form action="post"><input type="search" class="form-control" placeholder="Search...">
                                </form>
                            </li>
                        </ul>
                    </li><!-- / Search -->
                    <c:if test="${not empty sessionScope.get('accounts')}" var="accounts">
                        <li class="dropdown dropdown-slide">
                            <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                               data-delay="350"
                               role="button" aria-haspopup="true" aria-expanded="false"><i
                                    class="dropdown-toggle"></i>Welcome ${sessionScope.get('username')}<span
                                    class="tf-ion-ios-arrow-down"></span></a>
                            <div class="dropdown-menu">
                                <div class="row">
                                    <!-- Basic -->
                                    <div class="col-lg-12 col-md-6 mb-sm-3">
                                        <ul>
                                            <li>
                                                <a href="CustomerServlet?action=view&id=${sessionScope.get('id_account')}">Thông
                                                    tin tài khoản</a></li>
                                            <li role="separator" class="divider"></li>
                                            <li><a href="AccountServlet?action=change">Đổi mật khẩu</a></li>
                                            <li role="separator" class="divider"></li>
                                            <li><a href="AccountServlet?action=logout">Log out</a></li>
                                        </ul>
                                    </div>
                                </div><!-- / .row -->
                            </div><!-- / .dropdown-menu -->
                        </li>
                        <!-- / Elements -->
                    </c:if>
                    <c:if test="${empty sessionScope.get('accounts')}">
                        <li class="dropdown">
                            <a href="AccountServlet?action=login" class="dropdown-toggle"><i
                                    class="dropdown-toggle"></i>Login</a>
                        </li>
                    </c:if>


                </ul><!-- / .nav .navbar-nav .navbar-right -->
            </div>
        </div>
    </div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->
<section class="menu">
    <nav class="navbar navigation">
        <div class="container">
            <div class="navbar-header">
                <h2 class="menu-title">Main Menu</h2>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

            </div><!-- / .navbar-header -->

            <!-- Navbar Links -->
            <div id="navbar" class="navbar-collapse collapse text-center">
                <ul class="nav navbar-nav">

                    <!-- Home -->
                    <li class="dropdown ">
                        <a href="../index.jsp">Home</a>
                    </li><!-- / Home -->


                    <!-- Elements -->
                    <li class="dropdown dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                           data-delay="350"
                           role="button" aria-haspopup="true" aria-expanded="false">Jewels<span
                                class="tf-ion-ios-arrow-down"></span></a>
                        <div class="dropdown-menu">
                            <div class="row">

                                <!-- Basic -->
                                <div class="col-lg-3 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">Necklace</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="shop.html">Dây Chuyền Bạc 925</a></li>
                                        <li><a href="shop.html">Mặt Dây Chuyền Bạc 925</a></li>
                                        <li><a href="shop.html">Dây Chuyền Thời Trang</a></li>
                                        <li><a href="shop.html">Tất Cả</a></li>
                                    </ul>
                                </div>

                                <!-- Layout -->
                                <div class="col-lg-3 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">Bracelet</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="shop.html">Vòng Tay Bạc 925</a></li>
                                        <li><a href="shop.html">Vòng Tay Thời Trang</a></li>
                                        <li><a href="shop.html">Tất Cả</a></li>
                                    </ul>
                                </div>

                                <div class="col-lg-3 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">Ring</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="shop.html">Nhẫn Bạc Nam</a></li>
                                        <li><a href="shop.html">Nhẫn Thời Trang</a></li>
                                        <li><a href="shop.html">Tất Cả</a></li>
                                    </ul>
                                </div>

                                <div class="col-lg-3 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">Earring</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="shop.html">KHuyên Tai Bạc Nam</a></li>
                                    </ul>
                                </div>

                            </div><!-- / .row -->
                        </div><!-- / .dropdown-menu -->
                    </li><!-- / Elements -->

                </ul><!-- / .nav .navbar-nav -->

            </div>
            <!--/.navbar-collapse -->
        </div><!-- / .container -->
    </nav>
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
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
<script type="text/javascript" src="plugins/google-map/gmap.js"></script>

<!-- Main Js File -->
<script src="js/script.js"></script>


</body>
</html>
