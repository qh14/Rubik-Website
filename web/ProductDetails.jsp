<%-- 
    Document   : ProductDetails
    Created on : Jun 29, 2022, 3:12:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Detail</title>
    </head>
    <body>
        <jsp:useBean id="db" class="dao.ProductDAO"/>
        <%@include file="includes/header.jsp" %> 

        <c:set var="idp" value="${param.id}"/>
        <c:set var="pd" value="${db.getProductByID(idp)}"/>
        <c:if test="${empty pd}">
            <c:out value="EMPTY"/>
        </c:if>
        <section class="single_product_details_area d-flex align-items-center">

            <!-- Single Product Thumb -->
            <div class="single_product_thumb clearfix">
                <div class="product_thumbnail_slides owl-carousel">
                    <img src="${pd.getImage()}" alt="No Image">
                    <img src="${pd.getImage()}" alt="No Image">
                </div>
            </div>

            <!-- Single Product Description -->
            <div class="single_product_desc clearfix">
                <span>${pd.typeName}</span>
                <a href="cart.html">
                    <h2>${pd.productName}</h2>
                </a>
                <p class="product-price">${pd.getPrice()}</p>
                <p class="product-desc">${pd.info}</p>

                <!-- Form -->
                <form class="cart-form clearfix" method="post">              
                    <!-- Cart & Favourite Box -->
                    <div class="cart-fav-box d-flex align-items-center">
                        <!-- Cart -->
                        <div class="add-to-cart-btn">
                            <a href="BuyController?id=${idp}" class="btn essence-btn">Add to Cart</a>
                        </div>
                        <!-- Favourite -->

                        <c:if test="${not empty account}">
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
                            </div>
                        </c:if>
                        <c:if test="${empty account}">

                            <a href="SearchController?typeSearch=Favorite&id=${p.productID}" class="favme fa fa-heart"></a>

                        </c:if>
                    </div>
                </form>
            </div>
        </section>
        <!-- ##### Single Product Details Area End ##### -->
        <%@include file="includes/Footer.jsp" %>  
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
    </body>
</html>
