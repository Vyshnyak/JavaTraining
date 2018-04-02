<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration form</h1>
        <p>${requestScope.message} </p>
        <form method="post" action="/register">
            <label>Name: </label>
            <label><input type="text" name="name"></label> [A-Z][a-z]{1,20}<br>
            <label>Login: </label>
            <label><input type="text" name="login"></label> [A-Za-z0-9_]{1,20}<br>
            <input type="submit" name="Ok"><br>
        </form>
    </body>
</html>