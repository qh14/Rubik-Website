<%-- 
    Document   : AddProduct
    Created on : Jul 6, 2022, 4:13:52 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
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
        <jsp:useBean id="db" class="dao.ProductDAO" />
        <%@include file="includes/header.jsp" %> 
        <h2>ADD NEW PRODUCT</h2>
        <form action="AddProductServlet" method="POST" enctype="multipart/form-data">
            
            <table border="0">

                <tbody>
                    <tr>
                        <td>Product Name : </td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Product Type : </td>
                        <td>
                            <select name="type">
                                <c:forEach var="pt" items="${db.allSubTypeProduct}">
                                    <option value="${pt}">${pt}</option>
                                </c:forEach> 
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td>Product Price : </td>
                        <td><input type="text" name="price"></td>
                    </tr>
                    <tr>
                        <td>Product Info : </td>
                        <td><input type="text" name="info"></td>
                    </tr>
                    <tr>
                        <td>Product Image : </td>
                        <td><input type="file" name="image"></td>

                    </tr>
                    <tr>
                        <td>Number of Product : </td>
                        <td><input type="text" name="numberofproduct"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="action" value="ADD"></td>

                    </tr>
                </tbody>
            </table>

        </form>
            <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
                : request.getAttribute("errMessage")%></p>
            <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
                    : request.getAttribute("Message")%></p>  
            <%@include file="includes/Footer.jsp" %>
    </body>
</html>
