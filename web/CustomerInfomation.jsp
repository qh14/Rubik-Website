<%-- 
    Document   : CustomerInfomation
    Created on : Jun 26, 2022, 2:02:57 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Infomation</title>
        <link href="css/MyStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
       

        <c:if test="${empty account}">
            <p style="text-align: center;color: red;font-size: 16px">Please Login</p>
        </c:if>
        <c:if test="${not empty account}">
            <div class="UserInfomation">
                <div class="UserMenu">
                    <ul>
                        <li><a href="UserInfoController?action=UserInfo" style="color: black">Customer Info</a></li>
                        <li><a href="SearchController?typeSearch=Favorite" style="color: black">Favorite Item</a></li>
                        <li><a href="changePass.jsp" style="color: black">Change Password</a></li>
                        <li><a href="History.jsp" style="color: black">History</a></li>
                        <li><a href="UserInfoController?action=LogOut" style="color: black">Log Out</a></li>
                    </ul>
                </div>
                <div class="UserDetails">
                    <h2>User Infomation</h2>
                    <form name="info" action="UserInfoController" method="POST">


                        <table border="0" cellspacing="10">

                            <tbody>
                                <tr>
                                    <td>Name : </td>
                                    <td><input type="text" name="name" value="${sessionScope.account.customerName}"></td>

                                </tr>
                                <tr>
                                    <td>Phone Number : </td>
                                    <td><input type="text" name="phone" value="${sessionScope.account.customerPhone}"></td>

                                </tr>
                                <tr>
                                    <td>Address : </td>
                                    <td><input type="text" name="address" value="${sessionScope.account.customerAddress}"></td>

                                </tr>
                                <tr>
                                    <td> </td>
                                    <td><input type="submit" name="action" value="Save Change"></td>

                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>

            </div>
        </c:if>



        <%@include file="includes/Footer.jsp" %>
        <!-- /SECTION -->
       
    </body>
</html>
