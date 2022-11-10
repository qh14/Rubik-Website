<%-- 
    Document   : HistoryDetail
    Created on : Jul 12, 2022, 9:46:57 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.InvoiceDAO"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Detail</title>
        <style>
            table tr td{
                padding: 20px 50px 20px 50px;       
            }
            table tr th{
                padding: 20px 50px 20px 50px;   
                text-align: center;
            }
            table{
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <c:set var="id" value="${param.id}"/>
        <jsp:useBean id="db" class="dao.InvoiceDAO"/>
        <jsp:useBean id="dao" class="dao.ProductDAO"/>
        <c:if test="${id > 0}">
            <h2 style="text-align: center">Product Detail of Invoice ${id}</h2>
            <c:set var="list" value="${db.getDetailInvoice(id)}"/>
            <c:if test="${not empty list}">
                <table border="0">
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detail" items="${list}">
                            <c:set var="p" value="${dao.getProductByID(detail.productID)}"/>
                            <tr>
                                <td>${detail.productID}</td>
                                <td>${p.productName}</td>
                                <td>${detail.quantity}</td>
                                <td>${detail.quantity*p.getPrice()} USD</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><b>Total: </b>${param.total} USD</td>
                        </tr>
                    </tbody>
                </table>

            </c:if>
        </c:if>
        <%@include file="includes/Footer.jsp" %>
    </body>
</html>
