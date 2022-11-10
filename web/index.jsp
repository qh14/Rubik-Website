<%-- 
    Document   : index
    Created on : Jun 27, 2022, 8:14:46 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>

    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
        <!-- ##### Welcome Area Start ##### -->
        <video class="video-react-video" muted="" preload="auto" loop="" autoplay="" style="margin: -15px" src="//videos.ctfassets.net/r3qu44etwf9a/3gsxChj55LrmFT7644E7OZ/bb4c1a85688ec697f96410f79909d888/rubiks-hero-banner.mp4" tabindex="-1"></video>
        <section class="welcome_area bg-img background-overlay" style="background-image: url(img/bg-img/bg-1.jpg);">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <div class="hero-content">
                            <h6>SHOP RUBIK</h6>
                            <h2>New Collection</h2>
                            <a href="SearchController?typeSearch=All" class="btn essence-btn">view collection</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- ##### Welcome Area End ##### -->
        <!-- ##### Top Catagory Area Start ##### -->
        <div class="top_catagory_area section-padding-80 clearfix">
            <div class="container">
                <div class="row justify-content-center">
                    <!-- Single Catagory -->
                    <div class="col-12 col-sm-6 col-md-4">
                        <div class="single_catagory_area d-flex align-items-center justify-content-center bg-img" style="background-image: url(img/bg-img/bg-2.jpg);">
                            <div class="catagory-content">
                                <a href="ListByType.jsp?type=Type01&nameType=Regular-shaped cubes">Regular-shaped cubes </a>
                            </div>
                        </div>
                    </div>
                    <!-- Single Catagory -->
                    <div class="col-12 col-sm-6 col-md-4">
                        <div class="single_catagory_area d-flex align-items-center justify-content-center bg-img" style="background-image: url(img/bg-img/bg-3.jpg);">
                            <div class="catagory-content">
                                <a href="ListByType.jsp?type=Type03&nameType=Combo Rubik">Combo Rubik</a>
                            </div>
                        </div>
                    </div>
                    <!-- Single Catagory -->
                    <div class="col-12 col-sm-6 col-md-4">
                        <div class="single_catagory_area d-flex align-items-center justify-content-center bg-img" style="background-image: url(img/bg-img/bg-4.jpg);">
                            <div class="catagory-content">
                                <a href="ListByType.jsp?type=Type04&nameType=Rubik Accessories">Rubik Accessories</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ##### Top Catagory Area End ##### -->
        <!-- ##### New Arrivals Area Start ##### -->
        <jsp:useBean id="db" class="dao.ProductDAO"/>

        <section class="new_arrivals_area section-padding-80 clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="section-heading text-center">
                            <h2>Popular Products</h2>
                        </div>
                    </div>
                </div>
            </div>
            <c:set var="accountname" value="${sessionScope.account.username}"/>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="popular-products-slides owl-carousel">
                            <c:forEach var="p" items="${db.all}">
                                <!-- Single Product -->
                                <div class="single-product-wrapper">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src="${p.image}" alt="">
                                        <!-- Favourite -->
                                        <c:if test="${not empty account}">
                                            <div class="product-favourite">
                                                <c:set var="list" value="${sessionScope.listFavorite}"/>
                                                <c:if test="${not empty list}">
                                                    <c:if test="${db.searchFavorite(list,p.productID)>=0}">
                                                        <a href="SearchController?typeSearch=Favorite&id=${p.productID}" class="favme fa fa-heart" style="color: red"></a>
                                                    </c:if>
                                                    <c:if test="${db.searchFavorite(list,p.productID)<0}">

                                                        <a href="SearchController?typeSearch=Favorite&id=${p.productID}" class="favme fa fa-heart"></a>

                                                    </c:if>
                                                </c:if>
                                            </div>
                                        </c:if>
                                        <c:if test="${empty list}">
                                            <div class="product-favourite">
                                                <a href="SearchController?typeSearch=Favorite&id=${p.productID}" class="favme fa fa-heart"></a>
                                            </div>
                                        </c:if>
                                    </div>

                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <span>${p.typeName}</span>
                                        <a href="ProductDetails.jsp?id=${p.productID}">
                                            <h6>${p.productName}</h6>
                                        </a>
                                        <p class="product-price">${p.price}</p>

                                        <!-- Hover Content -->
                                        <div class="hover-content">
                                            <!-- Add to Cart -->
                                            <div class="add-to-cart-btn">
                                                <a href="BuyController?id=${p.productID}" class="btn essence-btn">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

        </section>
        <!-- jQuery (Necessary for All JavaScript Plugins) -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins js -->
        <script src="js/plugins.js"></script>
        <!-- Classy Nav js -->
        <script src="js/classy-nav.min.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>
        <%@include file="includes/Footer.jsp" %>  

    </body>
</html>
