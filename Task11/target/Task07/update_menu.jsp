<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 13.04.2018
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<html>
    <body>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Login</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="note" items="${requestScope.notes}">
                <tr>
                    <td>${note.id}</td>
                    <td>${note.firstName}</td>
                    <td>${note.login}</td>
                    <td>
                        <form method="POST" action="${pageContext.request.contextPath}/app/updateForm">
                            <input type="number" hidden name="id" value="${note.id}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>
