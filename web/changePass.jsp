<%-- 
    Document   : changePass
    Created on : Jul 19, 2022, 9:40:34 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
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
                        <li><a href="UserInfoController?action=FavoriteItem" style="color: black">Favorite Item</a></li>
                        <li><a href="UserInfoController?action=ChangePass" style="color: black">Change Password</a></li>
                        <li><a href="History.jsp" style="color: black">History</a></li>
                        <li><a href="UserInfoController?action=LogOut" style="color: black">Log Out</a></li>
                    </ul>
                </div>
                <div class="UserDetails">
                    <h2>Change Password</h2>
                    <form action="UserInfoController">
                        <input type="hidden" name="action" value="ChangePass"/>
                        <table>
                            <tr><td>Current Password</td><td><input type="password" name="current" ></td></tr>
                            <tr><td>New Password</td><td><input type="password" name="new"></td></tr>
                            <tr><td>Confirm Password</td><td><input type="password" name="confirm"></td></tr>
                            <tr><td><input type="submit" value="Change Password"></td></tr>
                        </table>
                    </form>
                        <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
                        : request.getAttribute("errMessage")%></p>
                        <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
                        : request.getAttribute("Message")%></p>
                        
                </div>

            </div>
        </c:if>



        <%@include file="includes/Footer.jsp" %>
    </body>
</html>
