<%-- 
    Document   : Login
    Created on : Jun 25, 2022, 9:27:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%@include file="includes/header.jsp" %>  
        
        <section>
            <div class="content">

                <div class="contentlogin">
                    <h1>Login Form</h1>
                    <form action="LoginServlet" method="POST">
                        <table border="0">

                            <tbody>
                                <tr>
                                    <td>Enter username : </td>
                                    <td><input type="text" name="user" value="${newUser.username}" class="textinput"/></td>
                                </tr>
                                <tr>
                                    <td>Enter password : </td>
                                    <td><input type="password" name="pass" value="${newUser.password}" class="textinput"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="checkbox" value="checked" name="checkboxbutton">Remember Me </td>
                                </tr>
                                <tr>
                                    <td> </td>
                                    <td>
                                        <input type="submit" value="Login" class="textsubmit" style="padding: 10px 80px;border-radius:8px;"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <a href = "<%=request.getContextPath()%>/Register.jsp" id = "link-register" style="text-decoration: none">Click here to Register</a>
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                        <h3 style="color: red;font-size: 14px;text-align: center">${requestScope.error}</h3>
                    </form>

                </div>
            </div>
        </section>
        <%@include file="includes/Footer.jsp" %>
        <!-- /SECTION -->
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
    </body>
</html>
