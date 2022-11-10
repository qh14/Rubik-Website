<%-- 
    Document   : ProductUpdate
    Created on : Jul 3, 2022, 3:59:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Update</title>
        <link rel="stylesheet" href="css/StyleCSS.css">
        <style>
            table tr td{
                padding: 20px .625em .625em .625em;   

            }
            table tr th{
                padding: 20px .625em .625em .625em;   
                text-align: center;
            }
            table{
                margin-right: auto;
                margin-left: auto;
            }
            input{
                padding:10px 20px 10px 20px;
            }
            h2{
                text-align: center;
            }
            input{width: 500px;text-align: center}

        </style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <jsp:useBean id="db" class="dao.ProductDAO"/>
        <c:set var="id" value="${requestScope.id}"/>
        <c:set var="p" value="${db.getProductByID(id)}"/>
        <h2>UPDATE PRODUCT INFORMATION</h2>
        <form action="ProductController" method="POST">

            <table border="0">

                <tbody>

                    <tr>
                        <td>ID : </td>
                        <td><input type="text" name="id" value="${p.getProductID()}" readonly></td>
                    </tr>
                    <tr>
                        <td>Name : </td>
                        <td><input type="text" value="${p.getProductName()}" name="name"></td>
                    </tr>
                    <tr>
                        <td>Type : </td>
                        <td>
                            <select name="type">
                                <option value="${p.getTypeName()}">${p.getTypeName()}</option>
                                <c:forEach var="pt" items="${db.allSubTypeProduct}">
                                    <c:if test="${!pt.equals(p.getTypeName())}">
                                        <option value="${pt}">${pt}</option>
                                    </c:if>
                                </c:forEach> 
                            </select>


                    </tr>
                    <tr>
                        <td>Price : </td>
                        <td><input type="text" value="${p.getPrice()}" name="price"></td>
                    </tr>
                    <tr>
                        <td>Info</td>
                        <td><input type="text" value="${p.getInfo()}" name="info"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="UPDATE/SAVE" name="action"></td>
                    </tr>
                </tbody>
            </table>

        </form>
        <%@include file="includes/Footer.jsp" %>  
    </body>
</html>
