<%-- 
    Document   : ListItem
    Created on : Jun 28, 2022, 10:11:18 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Buy Item</title>
        <link href="css/detail.css" rel="stylesheet" type="text/css"/> 
        <link href="css/MyStyle.css" rel="stylesheet" type="text/css"/> 
        <link rel="stylesheet" href="css/StyleCSS.css">
        <style>
            button{
                margin-left: auto;
                margin-right: 20%;
                display: block;
                margin-top: 10px;
            }

        </style>
    </head>
    <body>
        <div class="wrap">
            <%@include file="includes/header.jsp" %>
            <div class="content">
                <div class="main-content">

                    <div class="content-left">
                        <h1>Shopping Cart</h1>
                        <c:set var="i" value="${sessionScope.items}"/>
                        <c:set var="t" value="0"/>
                        <c:if test="${not empty i}">
                            <table class="tableitem" style="width: 80%;  margin-left: auto; margin-right: auto;">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Money</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="it" value="${sessionScope.items}"/>
                                    <jsp:useBean id="db" class="dao.ProductDAO"/>
                                    <c:forEach items="${db.updateListProduct(it)}" var="item">
                                        <c:set var="t" value="${t+1}"/>
                                        <tr>
                                            <td>${t}</td>

                                            <td>${item.product.productName}</td>
                                            <td>${item.product.price}</td>
                                            <td class="itemsQuantity">
                                                <button class="button-38"><a href="NumberItemController?num=-1&id=${item.product.productID}" style="color: black">-</a></button>
                                                <input type="text" readonly value="${item.quantity}" style="width: 50px;text-align: center"/>
                                                <button class="button-38"><a href="NumberItemController?num=1&id=${item.product.productID}" style="color: black;">+</a></button>
                                            </td>
                                            <td>${item.quantity*item.product.price}</td>
                                            <td>
                                                <form action="NumberItemController" method="POST">
                                                    <input type="hidden" name="id" value="${item.product.productID}"/>
                                                    <input type="submit" value="Remove Item" class="button-17"/>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <c:forEach items="${items}" var="item">


                                <c:set var="total" value="${total+item.quantity*item.product.price}" />

                            </c:forEach>
                            <br>
                            <div style="text-align: end;margin-right: 20%"><b> Total : </b> <c:out value="${total}"/>$</div>
                           <form action="AuthorizePaymentServlet" method="POST" >
                                <input type="hidden" value="${total}" name="total"/>
                                <input type="submit" value="BUY" style="margin-left: auto; margin-right: 20%; display: block;margin-top: 10px;padding: 10px 15px"/>
                            </form>


                        </c:if>
                        <c:out value="${mes}"/>
                        <c:if test="${empty i}">
                            <p style="text-align: center">Not Contain Any Product</p>
                        </c:if>

                    </div>


                </div>

                <%@include file="includes/Footer.jsp" %>

            </div>
        </div>
    </body>
</html>
