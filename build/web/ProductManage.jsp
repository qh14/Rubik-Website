<%-- 
    Document   : AccountManage
    Created on : Jul 2, 2022, 9:00:05 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manage</title>
        <link rel="stylesheet" href="css/StyleCSS.css">
        <style>
            table tr td{
                padding: 20px .625em .625em .625em;       
            }
            table tr th{
                padding: 20px .625em .625em .625em;   
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <jsp:useBean id="db" class="dao.ProductDAO"/>

        <div>
            <table border="0" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Type</th>
                        <th>Information</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="pd" items="${requestScope.ListProduct}">
                        <c:set var="p" value="${pd.info}"/>
                        <tr>
                            <td>${pd.productID}</td>
                            <td>${pd.productName}</td>
                            <td>${pd.price}</td>
                            <td>${pd.typeName}</td>
                            <td>${pd.info}</td>
                            <td><button class="button-17"><a href="ProductController?type=ProductUpdate&id=${pd.productID}" style="color: black">Update</a></button></td>
                            <td><button class="button-17"><a href="ProductController?type=ProductRemove&id=${pd.productID}" style="color: black">Remove</a></button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <nav aria-label="navigation">
            <ul class="pagination mt-50 mb-70">
                <li class="page-item"><a class="page-link" href="ProductController?type=Product&pageSearch=${page-1}"><i class="fa fa-angle-left"></i></a></li>
                        <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                            <c:if test="${page!= j}">
                        <li class="page-item"><a class="page-link" href="ProductController?type=Product&page=${j}">${j}</a></li>
                        </c:if>
                        <c:if test="${page == j}">
                        <li class="page-item"><a class="page-link" href="#" style="color: black">${j}</a></li>
                        </c:if>
                    </c:forEach>

                <li class="page-item"><a class="page-link" href="ProductController?type=Product&pageSearch=${page+1}"><i class="fa fa-angle-right"></i></a></li>
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
