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

</head>

<body id="body">

<!-- Start Top Header Bar -->
<jsp:include page="header-bar.jsp"></jsp:include>

<section class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="content">
                    <h1 class="page-name">${types.getName()}</h1>
                    <ol class="breadcrumb">
                        <li><a href="/ShopServlet">Home</a></li>
                        <li class="active">${types.getName()}</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="products section">
    <div class="container">
        <div class="row">

            <c:forEach items="${itemsList}" var="items">
                <c:set var="quantity" value="${items.getInventory()}" />
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
                                    <c:if test="${quantity > 0 && items.getAvailable() == 0}">
                                        <li>
                                            <a href="/CartServlet?itemId=${items.getId()}"><i
                                                    class="tf-ion-android-cart"></i></a>
                                        </li>
                                    </c:if>
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
                                            <c:if test="${quantity == 0 || items.getAvailable() == 1}">
                                                <button onclick="window.location.href='/CartServlet?itemId=${items.getId()}'" type="button" class="btn btn-main" disabled>Sold Out</button>
                                            </c:if>
                                            <c:if test="${quantity > 0 && items.getAvailable() == 0}">
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
