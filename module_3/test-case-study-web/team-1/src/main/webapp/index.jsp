<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
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
    <link rel="shortcut icon" type="image/x-icon" href="shop/images/favicon.png"/>

    <!-- Themefisher Icon font -->
    <link rel="stylesheet" href="shop/plugins/themefisher-font/style.css">
    <!-- bootstrap.min css -->
    <link rel="stylesheet" href="shop/plugins/bootstrap/css/bootstrap.min.css">

    <!-- Animate css -->
    <link rel="stylesheet" href="shop/plugins/animate/animate.css">
    <!-- Slick Carousel -->
    <link rel="stylesheet" href="shop/plugins/slick/slick.css">
    <link rel="stylesheet" href="shop/plugins/slick/slick-theme.css">

    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="shop/css/style.css">

</head>

<body id="body">

<!-- Start Top Header Bar -->
<jsp:include page="shop/header-bar.jsp"></jsp:include>

<div class="hero-slider" style="transition: 1s ease">
    <div class="slider-item th-fullpage hero-area" style="background-image: url(shop/images/slider/slider-1.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-center">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">#Thehome - Ring</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Elegant.....</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                       href="shop/shop.html">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
    <div class="slider-item th-fullpage hero-area" style="background-image: url(shop/images/slider/slider-3.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-right">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">#Thehome - Necklace</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Stylish.....</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                       href="shop/shop.html">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
    <div class="slider-item th-fullpage hero-area" style="background-image: url(shop/images/slider/slider-2.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-left">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">#Thehome - Earring</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Cool.....</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                       href="shop/shop.html">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="product-category section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="title text-center">
                    <h2>Product Category</h2>
                </div>
            </div>
            <div class="col-md-6">
                <div class="category-box">
                    <a href="#!">
                        <img src="shop/images/shop/category/category-1.png" alt=""/>
                        <div class="content">
                            <h3 style="color: whitesmoke">Bracelet</h3>
                        </div>
                    </a>
                </div>
                <div class="category-box">
                    <a href="#!">
                        <img src="shop/images/shop/category/category-2.png" alt=""/>
                        <div class="content">
                            <h3 style="color: whitesmoke">Ring</h3>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="category-box category-box-2">
                    <a href="#!">
                        <img src="shop/images/shop/category/category-3.png" alt=""/>
                        <div class="content">
                            <h3 style="color: whitesmoke">Necklace</h3>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="products section bg-gray">
    <div class="container">
        <div class="row">
            <div class="title text-center">
                <h2>Trendy Products</h2>
            </div>
        </div>
        <div class="row">

            <c:forEach items="${itemsList}" var="items">
                <div class="col-md-4">
                    <div class="product-item">
                        <div class="product-thumb">
                            <span class="bage">Hot</span>
                            <img class="img-responsive" style="height: 30em" src="item-image/${items.getItemType().getName()}/${items.getImageList().get(0).getUrl()}" alt="product-img"/>
                            <div class="preview-meta">
                                <ul>
                                    <li>
									<span data-toggle="modal" data-target="#product-modal${items.getId()}">
										<i class="tf-ion-ios-search-strong"></i>
									</span>
                                    </li>
                                    <li>
                                        <a href="#!"><i class="tf-ion-ios-heart"></i></a>
                                    </li>
                                    <li>
                                        <a href="#!"><i class="tf-ion-android-cart"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4><a href="shop/product-single.html">${items.getName()}</a></h4>
                            <p class="price">$${items.getPrice()}</p>
                        </div>
                    </div>
                </div>

                <!-- Modal -->
                <div class="modal product-modal fade" id="product-modal${items.getId()}">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="tf-ion-close"></i>
                    </button>
                    <div class="modal-dialog " role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-8 col-sm-6 col-xs-12">
                                        <div class="modal-image">
                                            <img class="img-responsive" src="item-image/${items.getItemType().getName()}/${items.getImageList().get(1).getUrl()}"
                                                 alt="product-img"/>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <div class="product-short-details">
                                            <h2 class="product-title">${items.getName()}</h2>
                                            <p class="product-price">$${items.getPrice()}</p>
                                            <p class="product-short-description">
                                                ${items.getDecreption()}
                                            </p>
                                            <a href="shop/cart.html" class="btn btn-main">Add To Cart</a>
                                            <a href="ShopServlet?action=viewDetail&id=${items.getId()}" class="btn btn-transparent">View Product
                                                Details</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
            </c:forEach>
        </div>
    </div>
</section>


<!--
Start Call To Action
==================================== -->
<section class="call-to-action bg-gray section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="title">
                    <h2>SUBSCRIBE TO NEWSLETTER</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, <br> facilis numquam impedit ut
                        sequi. Minus facilis vitae excepturi sit laboriosam.</p>
                </div>
                <div class="col-lg-6 col-md-offset-3">
                    <div class="input-group subscription-form">
                        <input type="text" class="form-control" placeholder="Enter Your Email Address">
                        <span class="input-group-btn">
				        <button class="btn btn-main" type="button">Subscribe Now!</button>
				      </span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->

            </div>
        </div>        <!-- End row -->
    </div>    <!-- End container -->
</section>   <!-- End section -->

<section class="section instagram-feed">
    <div class="container">
        <div class="row">
            <div class="title">
                <h2>View us on instagram</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="instagram-slider" id="instafeed"
                     data-accessToken="IGQVJYeUk4YWNIY1h4OWZANeS1wRHZARdjJ5QmdueXN2RFR6NF9iYUtfcGp1NmpxZA3RTbnU1MXpDNVBHTzZAMOFlxcGlkVHBKdjhqSnUybERhNWdQSE5hVmtXT013MEhOQVJJRGJBRURn"></div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="shop/footer-bar.jsp"></jsp:include>

<!--
Essential Scripts
=====================================-->

<!-- Main jQuery -->
<script src="shop/plugins/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.1 -->
<script src="shop/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Bootstrap Touchpin -->
<script src="shop/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
<!-- Instagram Feed Js -->
<script src="shop/plugins/instafeed/instafeed.min.js"></script>
<!-- Video Lightbox Plugin -->
<script src="shop/plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
<!-- Count Down Js -->
<script src="shop/plugins/syo-timer/build/jquery.syotimer.min.js"></script>

<!-- slick Carousel -->
<script src="shop/plugins/slick/slick.min.js"></script>
<script src="shop/plugins/slick/slick-animation.min.js"></script>

<!-- Google Mapl -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
<script type="text/javascript" src="shop/plugins/google-map/gmap.js"></script>

<!-- Main Js File -->
<script src="shop/js/script.js"></script>


</body>
</html>
