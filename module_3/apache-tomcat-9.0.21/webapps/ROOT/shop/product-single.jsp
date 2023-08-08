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
    <title>#Thehome - Product Single</title>

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

<section class="single-product">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <ol class="breadcrumb">
                    <li><a href="/ShopServlet">Home</a></li>
                    <li>
                        <a href="/ShopServlet?action=viewByType&idType=${items.getItemType().getId()}">${items.getItemType().getName()}</a>
                    </li>
                    <li class="active">${requestScope["items"].getName()}</li>
                </ol>
            </div>
        </div>
        <div class="row mt-20">
            <div class="col-md-5">
                <div class="single-product-slider">
                    <div id='carousel-custom' class='carousel slide' data-ride='carousel'>
                        <div class='carousel-outer'>
                            <!-- me art lab slider -->
                            <div class='carousel-inner '>
                                <c:forEach items="${imageList}" var="image" varStatus="loop">
                                    <div class='item <c:if test="${loop.first}">active</c:if>'>
                                        <img style="height: 35em; width: 100%"
                                             src='item-image/${requestScope["items"].getItemType().getName()}/${image.getUrl()}'
                                             alt=''
                                             data-zoom-image="item-image/${requestScope["items"].getItemType().getName()}/${image.getUrl()}"/>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- sag sol -->
                            <a class='left carousel-control' href='#carousel-custom' data-slide='prev'>
                                <i class="tf-ion-ios-arrow-left"></i>
                            </a>
                            <a class='right carousel-control' href='#carousel-custom' data-slide='next'>
                                <i class="tf-ion-ios-arrow-right"></i>
                            </a>
                        </div>
                        <!-- thumb -->
                        <ol class='carousel-indicators mCustomScrollbar meartlab'>
                            <c:forEach items="${imageList}" var="image" varStatus="loop">
                                <li data-target='#carousel-custom' data-slide-to='${loop.index}'
                                    <c:if test="${loop.first}">class='active'</c:if>>
                                    <img style="height: 5em"
                                         src='item-image/${requestScope["items"].getItemType().getName()}/${image.getUrl()}'
                                         alt=''/>
                                </li>
                            </c:forEach>
                        </ol>
                    </div>
                </div>
            </div>
            <div class="col-md-7">
                <form action="/CartServlet?itemId=${items.getId()}" method="post">
                    <div class="single-product-details">
                        <h2>${requestScope["items"].getName()}</h2>
                        <p class="product-price">$${requestScope["items"].getPrice()}</p>

                        <p class="product-description mt-20">
                            ${requestScope["items"].getDescription()}
                        </p>
                        <c:set var="quantity" value="${items.getInventory()}" />
                        <c:forEach var="list" items="${orderList}">
                            <c:if test="${list.getItems().getId() ==requestScope['items'].getId()}">
                                <c:set var="quantity" value="${items.getInventory() - list.getQuantity()}" />
                            </c:if>
                        </c:forEach>

                        <div class="product-quantity">
                            <span>Quantity:</span>
                            <div class="product-quantity-slider">
                                <input type="number" id="product-quantity" value="0" name="product-quantity" min="0" max="${quantity}">
                            </div>
                        </div>
                        <div class="product-category">
                            <span>Remain:</span>
                            ${quantity}
                        </div>
                        <c:if test="${quantity == 0 || items.getAvailable() == 1}">
                            <button type="submit" class="btn btn-main mt-20" disabled>Sold Out</button>
                        </c:if>
                        <c:if test="${quantity > 0 && items.getAvailable() == 0}">
                            <button type="submit" class="btn btn-main mt-20">Add To Cart</button>
                        </c:if>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<section class="products related-products section">
    <div class="container">
        <div class="row">
            <div class="title text-center">
                <h2>Related Products</h2>
            </div>
        </div>
        <div class="row">
            <c:set var="limit" value="4"/>
            <c:set var="count" value="0"/>
            <c:forEach items="${itemsList}" var="items1">
                <c:set var="quantity1" value="${items1.getInventory()}" />
                <c:if test="${count < limit}">
                    <div class="col-md-3">
                        <div class="product-item">
                            <div class="product-thumb">
                                <img class="img-responsive" style="height: 20em"
                                     src="item-image/${items1.getItemType().getName()}/${items1.getImageList().get(1).getUrl()}"
                                     alt="product-img"/>
                                <div class="preview-meta">
                                    <ul>
                                        <li>
									<span data-toggle="modal" data-target="#product-modal${items1.getId()}">
										<i class="tf-ion-ios-search"></i>
									</span>
                                        </li>
                                        <li>
                                            <a href="#"><i class="tf-ion-ios-heart"></i></a>
                                        </li>
                                        <li>
                                            <c:if test="${quantity1 > 0 && items1.getAvailable() == 0}">
                                                <a href="/CartServlet?itemId=${items1.getId()}" ><i
                                                        class="tf-ion-android-cart"></i></a>
                                            </c:if>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="product-content">
                                <h4><a href="product-single.html">${items1.getName()}</a></h4>
                                <p class="price">$${items1.getPrice()}</p>
                            </div>
                        </div>
                    </div>
                    <div class="modal product-modal fade" id="product-modal${items1.getId()}">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <i class="tf-ion-close"></i>
                        </button>
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="modal-image">
                                                <img class="img-responsive"
                                                     src="item-image/${items1.getItemType().getName()}/${items1.getImageList().get(1).getUrl()}"
                                                     alt="product-img"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="product-short-details">
                                                <h2 class="product-title">${items1.getName()}</h2>
                                                <p class="product-price">$${items1.getPrice()}</p>
                                                <p class="product-short-description">
                                                        ${items1.getDescription()}
                                                </p>
                                                <c:if test="${quantity1 == 0 || items1.getAvailable() == 1}">
                                                    <button onclick="window.location.href='/CartServlet?itemId=${items1.getId()}'" type="button" class="btn btn-main" disabled>Sold Out</button>
                                                </c:if>
                                                <c:if test="${quantity1 > 0 && items1.getAvailable() == 0}">
                                                    <button onclick="window.location.href='/CartServlet?itemId=${items1.getId()}'" type="button" class="btn btn-main" >Add
                                                        To Cart</button>
                                                </c:if>

                                                <a href="/ShopServlet?action=viewDetail&id=${items1.getId()}"
                                                   class="btn btn-transparent">View Product Details</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="count" value="${count + 1}"/>
                </c:if>
            </c:forEach>
        </div>
    </div>
</section>


<!-- Modal -->


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