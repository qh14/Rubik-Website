<%-- 
    Document   : Blog
    Created on : Jul 9, 2022, 4:05:53 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BlogDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
        <div class="breadcumb_area breadcumb-style-two bg-img" style="background-image: url(img/bg-img/breadcumb2.jpg);">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <div class="page-title text-center">
                            <h2>Rubik Blog</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:useBean id="db" class="dao.BlogDAO"/>
        <c:set var="listBlog" value="${db.all}"/>
        <c:if test="${not empty listBlog}">
            <div class="blog-wrapper section-padding-80">
                <div class="container">
                    <div class="row">
                        <c:forEach var="bl" items="${listBlog}">
                            <!-- Single Blog Area -->
                            <div class="col-12 col-lg-6">
                                <div class="single-blog-area mb-50">
                                    <img src="${bl.getBlogImage()}" alt="">
                                    <!-- Post Title -->
                                    <div class="post-title">
                                        <a href="#" style="color: black">${bl.getBlogName()}</a>
                                    </div>
                                    <!-- Hover Content -->
                                    <div class="hover-content">
                                        <!-- Post Title -->
                                        <div class="hover-post-title">
                                            <a href="#" style="color: black">${bl.getBlogName()}</a>
                                        </div>
                                        <p>${bl.getBlogDescription() }</p>
                                        <a href="${bl.getBlogLink()}">Continue reading <i class="fa fa-angle-right"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:if>
        <%@include file="includes/Footer.jsp" %>  
    </body>
</html>
