<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Notebook</title>
    </head>
    <body>
        <h1>Welcome to Notebook</h1>
        <h2>All notes</h2>
        <hr />
        <c:forEach var="note" items="${requestScope.notes}">
            <ul>

                <li>Name: <c:out value="${note.firstName}"/></li>

                <li>Login: <c:out value="${note.login}"/></li>
            </ul>
            <hr />

        </c:forEach>

        <h2>Create a new note</h2>
        <p>
            ${requestScope.message}
        </p>
        <form method="post" action="">
            <label><input type="text" name="name"></label>Name [A-Z][a-z]{1,20}<br>

            <label><input type="text" name="login"></label>Login [A-Za-z0-9_]{1,20}<br>

            <input type="submit" value="Ok" name="Ok"><br>
        </form>
    </body>
</html>