<%-- 
    Document   : home
    Created on : Oct 11, 2021, 3:12:52 PM
    Author     : 504785
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <p> Hello ${user.username}</p>
        <div>
        <a href="login?out">Log out</a>
        </div>
    </body>
</html>
