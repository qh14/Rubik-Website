<%-- 
    Document   : Contact
    Created on : Jul 6, 2022, 2:33:25 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ShopInfoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        
    </head>
    <body>
        <!-- ##### Right Side Cart End ##### -->
        <%@include file="includes/header.jsp" %>
        <jsp:useBean id="db" class="dao.ShopInfoDAO"/>
        <c:set var="info" value="${db.info}"/>
        <div class="contact-area d-flex align-items-center">

            <div class="google-map">
                <div id="googleMap" style="height: 50%">
                    
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5342.819778130756!2d105.81398585134787!3d21.0414664716021!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab11e82253ef%3A0x2907ac18448f7377!2sH2%20Rubik%20Shop!5e0!3m2!1svi!2s!4v1657093146505!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>

            <div class="contact-info">
                <h2>How to Find Us</h2>
                <p>${info.shopDescription}</p>

                <div class="contact-address mt-50">
                    <p><span>address:</span> ${info.shopAddress}</p>
                    <p><span>telephone:</span> ${info.shopPhone}</p>
                    <p><a href="mailto:contact@essence.com">${info.shopEmail}</a></p>
                </div>
            </div>

        </div>
        <%@include file="includes/Footer.jsp" %>  
    </body>
</html>
