<%-- 
    Document   : Error
    Created on : Jun 28, 2022, 9:31:59 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <h1>Error!</h1>
        <p>Exception is:</p>
        ${requestScope.exception}
        <%@include file="includes/Footer.jsp" %>
    </body>
</html>
