<%-- 
    Document   : History
    Created on : Jul 12, 2022, 9:20:14 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.InvoiceDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
        <style>
            table tr td{
                padding: 20px 50px 20px 50px;       
            }
            table tr th{
                padding: 20px 50px 20px 50px;   
                text-align: center;
            }
            
        </style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <jsp:useBean id="db" class="dao.InvoiceDAO"/>
        <c:set var="customerID" value="${sessionScope.account.customerID}"/>
        <c:if test="${not empty customerID}">
            <h2 style="text-align: center">History of ${sessionScope.account.customerName}</h2>
            <c:set var="list" value="${db.getHistory(customerID)}"/>
            <c:if test="${not empty list}">
                <table border="0" style="margin: 0 auto;">
                    <thead>
                        <tr>
                            <th>Invoice ID</th>
                            <th>Total Price</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="i" items="${list}">
                            <tr>
                                <td>${i.getInvoiceID()}</td>
                                <td>${i.getTotalPrice()}</td>
                                <td><button><a href="HistoryDetail.jsp?id=${i.getInvoiceID()}&total=${i.getTotalPrice()}" style="color: black">See Detail</a></button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty list}">
                <h2>Not have any history</h2>
            </c:if>
        </c:if>


        <%@include file="includes/Footer.jsp" %>
    </body>
</html>
