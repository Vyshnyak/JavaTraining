<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 13.04.2018
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<html>
    <body>
    <div class="html-editor-align-center">
        Name: ${sessionScope.note.firstName}
        <br>
        Login: ${sessionScope.note.login}
        <br>
        <p>${requestScope.message} </p>
        <form class="form-inline" method="POST" action="${pageContext.request.contextPath}/app/update">
            <input type="text" class="form-control mr-2" name="firstName" placeholder="First Name">
            <input type="text" class="form-control mr-2" name="login" placeholder="Login">
            <input type="number" hidden name="id" value="${requestScope.note.id}">
            <button type="submit" class="btn btn-secondary">Update</button>
        </form>
    </div>
    </body>
</html>
