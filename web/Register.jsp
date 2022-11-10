<%-- 
    Document   : Register
    Created on : Jun 26, 2022, 9:52:19 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>

    </head>
    <%@include file="includes/header.jsp" %>  
    
    <body>

        <div class="register">
            <h1>Create Account</h1>
            <form name="formregister" action="RegisterServlet" method="POST">
                <table border="0">

                    <tbody>
                        <tr>
                            <td>Enter Name : </td>
                            <td><input type="text" name="name"  class="textinput"/></td>
                        </tr>
                        <tr>
                            <td>Enter Address : </td>
                            <td><input type="text" name="address" class="textinput"/></td>
                        </tr>

                        <tr>
                            <td>Enter Phone Number : </td>
                            <td><input type="text" name="phone" class="textinput"/></td>
                        </tr>
                        <tr>
                            <td>Enter User Name : </td>
                            <td><input type="text" name="user" class="textinput"/></td>
                        </tr>
                        <tr>
                            <td>Enter Password : </td>
                            <td><input type="password" name="pass" class="textinput"/></td>
                        </tr>
                        <tr>
                            <td>Confirm Password : </td>
                            <td><input type="password" name="confirmPass" class="textinput"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Create"/></td>
                        </tr>

                    </tbody>

                </table>

            </form>
            <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
                        : request.getAttribute("errMessage")%></p>
            <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
                        : request.getAttribute("Message")%></p>  
        </div>
    </body>
    <%@include file="includes/Footer.jsp" %>
</html>
