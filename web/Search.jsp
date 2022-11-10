<%-- 
    Document   : Search
    Created on : Jun 27, 2022, 11:13:44 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link href="css/MyStyle.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
        <jsp:useBean id="st" class="dao.ProductDAO"/>
        
        <!-- ##### Breadcumb Area Start ##### -->
        <div class="breadcumb_area bg-img" style="background-image: url(img/bg-img/breadcumb.jpg);">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <div class="page-title text-center">
                            <h2>RUBIK SHOP</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ##### Breadcumb Area End ##### -->
        <!-- ##### Shop Grid Area Start ##### -->
        <c:set var="typesearch" value="${requestScope.Type}"/> 
        <c:set var="searchvalue" value="${requestScope.searchvalue}"/> 
        <jsp:useBean id="db" class="dao.ProductDAO"/>
        <section class="shop_grid_area section-padding-80">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-4 col-lg-3">
                        <div class="shop_sidebar_area">

                            <!-- ##### Single Widget ##### -->
                            <div class="widget catagory mb-50">
                                <!-- Widget Title -->
                                <h6 class="widget-title mb-30">Catagories</h6>

                                <!--  Catagories  -->
                                <div class="catagories-menu">
                                    <c:forEach var="type" items="${db.typeProduct}">
                                        <ul id="menu-content2" class="menu-content collapse show">
                                            <c:set var="a" value="${type}"/>
                                            <!-- Single Item -->
                                            <li data-toggle="collapse" data-target="#clothing">
                                                <a href="#" style="color: black">${type}</a>

                                                <ul class="sub-menu collapse show" id="clothing">
                                                    <c:forEach var="sub" items="${db.getSubTypeProduct(a)}">                                                                                             
                                                        <li><a href="SearchController?search=${sub}&typeSearch=Type">${sub}</a></li>
                                                        </c:forEach>
                                                </ul>

                                            </li>

                                        </ul>
                                    </c:forEach>
                                </div>
                            </div>

                            
                        </div>
                    </div>

                    <div class="col-12 col-md-8 col-lg-9">
                        <div class="shop_grid_product_area">
                            <div class="row">
                                <div class="col-12">
                                    <div class="product-topbar d-flex align-items-center justify-content-between">
                                        <!-- Total Products -->
                                        <div class="total-products">
                                            <p><span>${requestScope.totalitem}</span> products found</p>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <c:out value="${requestScope.noContent}"/>
                                <c:forEach var="pd" items="${requestScope.listSearch}">
                                    <!-- Single Product -->
                                    <div class="col-12 col-sm-6 col-lg-4">
                                        <div class="single-product-wrapper">
                                            <!-- Product Image -->
                                            <div class="product-img">
                                                <img src="${pd.image}" alt="">




                                                <!-- Favourite -->

                                                <div class="product-favourite">
                                                    <c:set var="list" value="${sessionScope.listFavorite}"/>
                                                    <c:if test="${not empty list}">
                                                        <c:if test="${db.searchFavorite(list,pd.productID)>=0}">
                                                            <a href="SearchController?typeSearch=Favorite&id=${pd.productID}" class="favme fa fa-heart" style="color: red"></a>
                                                        </c:if>
                                                        <c:if test="${db.searchFavorite(list,pd.productID)<0}">

                                                            <a href="SearchController?typeSearch=Favorite&id=${pd.productID}" class="favme fa fa-heart"></a>

                                                        </c:if>
                                                    </c:if>
                                                    <c:if test="${empty list}">

                                                        <a href="SearchController?typeSearch=Favorite&id=${pd.productID}" class="favme fa fa-heart"></a>

                                                    </c:if>
                                                </div>


                                            </div>

                                            <!-- Product Description -->
                                            <div class="product-description">
                                                <span>${pd.typeName}</span>
                                                <a href="ProductDetails.jsp?id=${pd.productID}">
                                                    <h6>${pd.productName}</h6>
                                                </a>
                                                <p class="product-price">${pd.price}</p>

                                                <!-- Hover Content -->
                                                <div class="hover-content">
                                                    <!-- Add to Cart -->
                                                    <div class="add-to-cart-btn">
                                                        <a href="BuyController?id=${pd.productID}" class="btn essence-btn">Add to Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <nav aria-label="navigation">
                            <ul class="pagination mt-50 mb-70">
                                <li class="page-item"><a class="page-link" href="SearchController?search=${searchvalue}&typeSearch=${typesearch}&pageSearch=${pageSearch-1}"><i class="fa fa-angle-left"></i></a></li>
                                        <c:forEach var="j" begin="1" step="1" end="${totalPageSearch}">
                                            <c:if test="${pageSearch != j}">
                                        <li class="page-item"><a class="page-link" href="SearchController?search=${searchvalue}&typeSearch=${typesearch}&pageSearch=${j}">${j}</a></li>
                                        </c:if>
                                        <c:if test="${pageSearch == j}">
                                        <li class="page-item"><a class="page-link" href="#" style="color: black">${j}</a></li>
                                        </c:if>
                                    </c:forEach>

                                <li class="page-item"><a class="page-link" href="SearchController?search=${searchvalue}&typeSearch=${typesearch}&pageSearch=${pageSearch+1}"><i class="fa fa-angle-right"></i></a></li>
                            </ul>
                        </nav>
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
