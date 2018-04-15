<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <h1>Notebook</h1>
        <%--<a href="create_form.jsp">Create</a>
        <a href="read.jsp">Read</a>
        <a href="update_menu.jsp">Update</a>
        <a href="delete_menu.jsp">Delete</a>--%>
        <form method="GET" action="${pageContext.request.contextPath}/create_form.jsp">
            <input type="submit" value="Create">
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/app/read">
            <input type="submit" value="Read">
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/app/updateMenu">
            <input type="submit" value="Update">
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/app/deleteMenu">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>