<%-- 
    Document   : receipt
    Created on : Jul 17, 2022, 9:29:46 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.InvoiceDAO"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt Page</title>
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
        <c:set var="id" value="${requestScope.idBuy}"/>
        <jsp:useBean id="db" class="dao.InvoiceDAO"/>
        <jsp:useBean id="dao" class="dao.ProductDAO"/>
        <c:if test="${id > 0}">
            
            <c:set var="list" value="${db.getDetailInvoice(id)}"/>
            <c:if test="${not empty list}">
                <h4 style="text-align: center;padding-bottom: 3%">Payment Done. Thank you for purchasing our products</h4>
                <p style="text-align: center">Receipt Details:</p>
                <br/>
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
                                <td>${detail.quantity*p.getPrice()}USD</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><b>Total: </b>${requestScope.total}USD</td>
                        </tr>
                    </tbody>
                </table>

            </c:if>
        </c:if>
        <%@include file="includes/Footer.jsp" %>

    </body>
</html>
