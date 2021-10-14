<%-- 
    Document   : login
    Created on : Oct 11, 2021, 3:12:38 PM
    Author     : 504785
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <br>
        
        <form method="POST" action="login">
            <label>Username: </label>
            <input type="text"  name="username" value="${username}">
            <br>
            <label>Password: </label>
            <input  type="text"  name="password" value="${password}">
            <br><br>
            <input type="submit" value="Log in">
       
        </form>
            <p>${out}</p>
    </body>
</html>
