<%-- 
    Document   : FavoriteProduct
    Created on : Jul 1, 2022, 1:12:20 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Favorite Product</title>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
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


        <jsp:useBean id="db" class="dao.ProductDAO"/>

        <c:set var="listFromTo" value="${requestScope.listFavoriteFromTo}"/>




        <div class="row" style="margin-left: 10%;margin-right: 10%">
            <c:if test="${not empty listFromTo}">
                <c:forEach var="pd" items="${listFromTo}">
                    <!-- Single Product -->
                    <div class="col-12 col-sm-6 col-lg-4">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pd.image}" alt="">
                                <!-- Favourite -->
                                <div class="product-favourite">
                                    <a href="SearchController?typeSearch=Favorite&id=${pd.productID}" class="favme fa fa-heart" style="color:red" ></a>
                                </div>
                            </div>

                            <!-- Product Description -->
                            <div class="product-description">
                                <span>topshop</span>
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
            </c:if>
        </div>


        <nav aria-label="navigation">
            <ul class="pagination mt-50 mb-70">
                <li class="page-item"><a class="page-link" href="#"><i class="fa fa-angle-left"></i></a></li>
                        <c:forEach var="j" begin="1" step="1" end="${totalPageFavorite}">
                            <c:if test="${pageFavorite != j}">
                        <li class="page-item"><a class="page-link" href="SearchController?typeSearch=Favorite&pageFavorite=${j}">${j}</a></li>
                        </c:if>
                        <c:if test="${pageFavorite  == j}">
                        <li class="page-item"><a class="page-link" href="#" style="color: black">${j}</a></li>
                        </c:if>
                    </c:forEach>

                <li class="page-item"><a class="page-link" href="#"><i class="fa fa-angle-right"></i></a></li>
            </ul>
        </nav>





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
