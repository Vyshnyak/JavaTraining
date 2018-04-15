<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 13.04.2018
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <h1>Registration form</h1>
        <br>
        Fill the registration form below:
        <br>
        <p>${requestScope.message} </p>
        <form method="POST" action="${pageContext.request.contextPath}/app/create">
            <label>Name: </label>
            <label><input type="text" name="firstName"></label> [A-Z][a-z]{1,20}<br>
            <label>Login: </label>
            <label><input type="text" name="login"></label> [A-Za-z0-9_]{1,20}<br>
            <input type="submit" value="Create"><br>
        </form>
    </body>
</html>
