<%-- 
    Document   : AddBlogContent
    Created on : Jul 9, 2022, 8:52:12 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Blog Content</title>
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
        <h2>ADD CONTENT</h2>
        <form action="BlogController" method="POST" enctype="multipart/form-data">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td>Blog Name : </td>
                        <td><input type="text" name="name" ></td>
                    </tr>
                    <tr>
                        <td>Blog Description : </td>
                        <td><input type="text" name="des" ></td>
                    </tr>
                    <tr>
                        <td>Blog Link : </td>
                        <td><input type="text" name="link" ></td>
                    </tr>
                    <tr>
                        <td>Blog Image : </td>
                        <td><input type="file" name="image" ></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="action" value="ADD"></td>
                    </tr>
                </tbody>
            </table>

            
            
        </form>
        
        
        <%@include file="includes/Footer.jsp" %> 
    </body>
</html>
