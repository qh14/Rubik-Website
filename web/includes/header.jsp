<%-- 
    Document   : header
    Created on : Jun 27, 2022, 8:12:06 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title  -->
        <title>Essence - Fashion Ecommerce Template</title>

        <!-- Favicon  -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Core Style CSS -->
        <link rel="stylesheet" href="css/core-style.css">
        <link rel="stylesheet" href="css/style.css">

    </head>

    <body>

        <!-- ##### Header Area Start ##### -->
        <header class="header_area">
            <div class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
                <!-- Classy Menu -->
                <nav class="classy-navbar" id="essenceNav">
                    <!-- Logo -->
                    <a class="nav-brand" href="index.jsp"><img src="img/core-img/logo.png" alt=""></a>
                    <!-- Navbar Toggler -->
                    <div class="classy-navbar-toggler">
                        <span class="navbarToggler"><span></span><span></span><span></span></span>
                    </div>
                    <!-- Menu -->
                    <div class="classy-menu">
                        <!-- close btn -->
                        <div class="classycloseIcon">
                            <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                        </div>
                        <jsp:useBean id="typelist" class="dao.ProductDAO"/>
                        <!-- Nav Start -->
                        <div class="classynav">
                            <ul>
                                <li><a href="#">Shop</a>

                                    <div class="megamenu">
                                        <c:forEach var="type" items="${typelist.typeProduct}">
                                            <c:set var="a" value="${type}"/>
                                            <ul class="single-mega cn-col-4">
                                                <li class="title">${type}</li>
                                                    <c:forEach var="sub" items="${typelist.getSubTypeProduct(a)}">  
                                                    <li><a href="SearchController?&typeSearch=Type&search=${sub}">${sub}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </c:forEach>       
                                        <div class="single-mega cn-col-4">
                                            <img src="img/bg-img/bg-2.jpg" alt="">
                                        </div>
                                    </div>
                                </li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="index.jsp">Home</a></li>
                                        <li><a href="SearchController?typeSearch=All">Shop</a></li>
                                        <li><a href="Blog.jsp">Blog</a></li>
                                        <li><a href="Contact.jsp">Contact</a></li>
                                    </ul>
                                </li>
                                <li><a href="Blog.jsp">Blog</a></li>
                                <li><a href="Contact.jsp">Contact</a></li>
                                    <c:if test="${sessionScope.account.isRoleAdmin()}">
                                    <li>
                                        <a href="#">Management</a>
                                        <ul class="dropdown">
                                            <li><a href="ProductController?type=Product">Product Editing</a></li>
                                            <li><a href="ShopInfoUpdate.jsp">Shop Info</a></li>
                                            <li><a href="AddProduct.jsp">Add New Product</a></li>
                                            <li><a href="AddBlog.jsp">Add New Blog</a></li>
                                        </ul>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                        <!-- Nav End -->
                    </div>
                </nav>

                <!-- Header Meta Data -->
                <div class="header-meta d-flex clearfix justify-content-end">
                    <!-- Search Area -->
                    <div class="search-area">
                        <form action="SearchController" method="GET">
                            <input type="search" name="search" id="headerSearch" placeholder="Type for search">
                            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                            <input type="hidden" name="typeSearch" value="Name"/>
                        </form>
                    </div>
                    <!-- Favourite Area -->
                    <div class="favourite-area">
                        <a href="SearchController?typeSearch=Favorite"><img src="img/core-img/heart.svg" alt=""></a>
                    </div>
                    <!-- User Login Info -->
                    <div class="user-login-info">

                        <c:if test="${not empty account}">
                            <a href="CustomerInfomation.jsp"><i class="fa fa-user-o"></i> ${account.username}</a>
                        </c:if>
                        <c:if test="${empty account}">
                            <a href="Login.jsp"><i class="fa fa-user-o"></i> Log in </a>
                        </c:if>

                    </div>
                    <!-- Cart Area -->
                    <div class="cart-area">
                        <a href="ListItem.jsp" id="essenceCartBtn"><img src="img/core-img/bag.svg" alt=""> <span>${size}</span></a>
                    </div>
                </div>

            </div>
        </header>
        <!-- ##### Header Area End ##### -->
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