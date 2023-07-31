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

<section class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="content">
                    <h1 class="page-name">Checkout</h1>
                    <ol class="breadcrumb">
                        <li><a href="/ShopServlet">Home</a></li>
                        <li class="active">checkout</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="page-wrapper">
    <div class="checkout shopping">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="block billing-details">
                        <h4 class="widget-title">Billing Details</h4>
                        <form class="checkout-form">
                            <div class="form-group">
                                <label for="name">Full Name</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="" value="${customers.getName()}">
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="" value="${customers.getPhone()}">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" name="address" placeholder="" value="${customers.getAddress()}">
                            </div>
                        </form>
                    </div>
                    <div class="block">
                        <h4 class="widget-title">Payment Method</h4>
                        <p>Credit Cart Details (Secure payment)</p>
                        <div class="checkout-product-details">
                            <div class="payment">
                                <div class="card-details">
                                    <form class="checkout-form">
                                        <div class="form-group">
                                            <label for="card-number">Card Number <span class="required">*</span></label>
                                            <input id="card-number" class="form-control" type="tel"
                                                   placeholder="•••• •••• •••• ••••">
                                        </div>
                                        <div class="form-group half-width padding-right">
                                            <label for="card-expiry">Expiry (MM/YY) <span
                                                    class="required">*</span></label>
                                            <input id="card-expiry" class="form-control" type="tel"
                                                   placeholder="MM / YY">
                                        </div>
                                        <div class="form-group half-width padding-left">
                                            <label for="card-cvc">Card Code <span class="required">*</span></label>
                                            <input id="card-cvc" class="form-control" type="tel" maxlength="4"
                                                   placeholder="CVC">
                                        </div>
                                        <a href="confirmation.html" class="btn btn-main mt-20">Place Order</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="product-checkout-details">
                        <div class="block">
                            <h4 class="widget-title">Order Summary</h4>
                            <c:set var="sum" value="${0}"/>
                            <c:forEach items="${orderList}" var="orderList">
                                <div class="media product-card">
                                    <a class="pull-left" href="/ShopServlet?action=viewDetail&id=${orderList.getItems().getId()}">
                                        <img class="media-object" src="item-image/${orderList.getItems().getItemType().getName()}/${orderList.getItems().getImageList().get(0).getUrl()}" alt="Image"/>
                                    </a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="/ShopServlet?action=viewDetail&id=${orderList.getItems().getId()}">${orderList.getItems().getName()}</a></h4>
                                        <p class="price">${orderList.getQuantity()} x $${orderList.getPrice()}</p>
                                        <span class="remove"><a href="/ShopServlet?action=deleteCart&id=${orderList.getItems().getId()}" class="remove"></a></span>
                                    </div>
                                </div>
                                <ul class="summary-prices">
                                    <li>
                                        <span>Subtotal:</span>
                                        <span class="price">$${orderList.getQuantity() * orderList.getPrice()}</span>
                                    </li>
                                    <li>
                                        <span>Shipping:</span>
                                        <span>Free</span>
                                    </li>
                                </ul>
                                <c:set var="sum" value="${sum + orderList.getQuantity() * orderList.getPrice()}"/>
                            </c:forEach>
                            <div class="summary-total">
                                <span>Total</span>
                                <span>$${sum}</span>
                            </div>
                            <div class="verified-icon">
                                <img src="images/shop/verified.png" alt="">
                            </div>
                        </div>
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