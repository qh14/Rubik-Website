<%-- 
    Document   : ShopInfoUpdate
    Created on : Jul 6, 2022, 3:26:21 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ShopInfoDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop Info Update</title>
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
        <jsp:useBean id="db" class="dao.ShopInfoDAO"/>

        <c:set var="p" value="${db.info}"/>
        <h2>UPDATE SHOP INFORMATION</h2>
        <form action="ShopInfoManagement" method="POST">

            <table border="0">

                <tbody>

                    <tr>
                        <td>Name : </td>
                        <td><input type="text" name="name" value="${p.shopName}" readonly></td>
                    </tr>
                    <tr>
                        <td>Description : </td>
                        <td><input type="text" value="${p.shopDescription}" name="description"></td>
                    </tr>
                    <tr>
                        <td>Phone : </td>

                        <td><input type="text" value="${p.shopPhone}" name="phone"></td>

                    </tr>
                    <tr>
                        <td>Email : </td>
                        <td><input type="text" value="${p.shopEmail}" name="email"></td>
                    </tr>
                    <tr>
                        <td>Address : </td>
                        <td><input type="text" value="${p.shopAddress}" name="address"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="UPDATE/SAVE" name="action"></td>
                    </tr>
                </tbody>
            </table>

        </form>




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
