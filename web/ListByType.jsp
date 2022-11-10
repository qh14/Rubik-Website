<%-- 
    Document   : ListByType
    Created on : Jul 18, 2022, 9:17:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product </title>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
        <c:set var="type" value="${param.type}"/>
        <jsp:useBean id="db" class="dao.ProductDAO"/>
        <h2 style="text-transform: uppercase;text-align: center;margin-top: 10%;margin-bottom: 10%">${param.nameType}</h2>
        <div class="row" style="margin-left: 10%;margin-right: 10%">
            
            <c:forEach var="pd" items="${db.getListProductByType(type)}">
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
        <%@include file="includes/Footer.jsp" %>  
    </body>
</html>
