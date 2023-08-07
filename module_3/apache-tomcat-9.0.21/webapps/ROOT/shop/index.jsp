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
    <title>#Thehome - Home</title>

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

    <style>
        .video-container {
            position: relative;
            width: 100%;
            height: 100vh; /* Chiều cao của màn hình */
            background-color: #f9f9f9;
            overflow: hidden;
        }

        .video-container video {
            width: 100%;
            height: 100%; /* Để video tràn chiều cao của vùng chứa */
            object-fit: cover; /* Đảm bảo video tràn hết vùng chứa */
        }
    </style>
</head>


<body id="body">

<!-- Start Top Header Bar -->
<jsp:include page="header-bar.jsp"></jsp:include>

<div class="hero-slider" style="transition: 1s ease">
    <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/slider-1.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-center">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">#Thehome - Ring</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Elegant.....</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                       href="/ShopServlet?action=viewByType&idType=4">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
    <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/slider-3.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-right">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">#Thehome - Earring</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Stylish.....</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                       href="/ShopServlet?action=viewByType&idType=2">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
    <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/slider-2.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-left">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">#Thehome - Necklace</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Cool.....</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                       href="/ShopServlet?action=viewByType&idType=3">Shop Now</a>
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
                    <a href="/ShopServlet?action=viewByType&idType=1">
                        <img src="images/shop/category/category-1.png" alt=""/>
                        <div class="content">
                            <h3 style="color: whitesmoke">Bracelet</h3>
                        </div>
                    </a>
                </div>
                <div class="category-box">
                    <a href="/ShopServlet?action=viewByType&idType=4">
                        <img src="images/shop/category/category-2.png" alt=""/>
                        <div class="content">
                            <h3 style="color: whitesmoke">Ring</h3>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="category-box category-box-2">
                    <a href="/ShopServlet?action=viewByType&idType=3">
                        <img src="images/shop/category/category-3.png" alt=""/>
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
                            <img class="img-responsive" style="height: 30em"
                                 src="item-image/${items.getItemType().getName()}/${items.getImageList().get(0).getUrl()}"
                                 alt="product-img"/>
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
                                        <a href="/CartServlet?itemId=${items.getId()}"><i
                                                class="tf-ion-android-cart"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4><a href="/ShopServlet?action=viewDetail&id=${items.getId()}">${items.getName()}</a></h4>
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
                                            <img class="img-responsive"
                                                 src="item-image/${items.getItemType().getName()}/${items.getImageList().get(1).getUrl()}"
                                                 alt="product-img"/>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <div class="product-short-details">
                                            <h2 class="product-title">${items.getName()}</h2>
                                            <p class="product-price">$${items.getPrice()}</p>
                                            <p class="product-short-description">
                                                    ${items.getDescription()}
                                            </p>
                                            <c:if test="${items.getInventory() > 0}">
                                                <a href="/CartServlet?itemId=${items.getId()}" class="btn btn-main">Add
                                                    To Cart</a>
                                            </c:if>
                                            <a href="/ShopServlet?action=viewDetail&id=${items.getId()}"
                                               class="btn btn-transparent">View Product
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

<div class="slider-item th-fullpage hero-area">
    <div class="video-container" style="height: 100%; background-color: #f9f9f9">
        <video id="custom-video" width="100%" height="725" autoplay loop muted playsinline>
            <source src="../video/HELIOS%20-%20HÃNG%20TRANG%20SỨC%20MỌI%20NGƯỜI%20CẦN%20BIẾT%20ĐẾN.mp4"
                    type="video/mp4">
            Your browser does not support the video tag.
        </video>
    </div>
</div>

<script>

    document.addEventListener('DOMContentLoaded', () => {
        const video = document.getElementById('custom-video');
        let startTime = 213; // Thời gian bắt đầu (3:33)
        let endTime = 256; // Thời gian kết thúc (4:16)

        video.currentTime = startTime;
        video.play();

        video.addEventListener('timeupdate', () => {
            if (video.currentTime >= endTime) {
                video.currentTime = startTime;
            }
        });
    });
    window.onload = function () {
        // Thực hiện cuộn trang lên đầu khi tải xong
        window.scrollTo(0, 0);
    };
</script>

<!--
Start Call To Action
==================================== -->
<section class="call-to-action bg-gray section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="title">
                    <h2>SUBSCRIBE TO NEWSLETTER</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, <br> facilis numquam
                        impedit ut
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

<!-- Main Js File -->
<script src="js/script.js"></script>


</body>
</html>
