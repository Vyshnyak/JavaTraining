<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <body>
    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="messages" var="lan" />
        <form method="GET" action="${pageContext.request.contextPath}/app/language/menu">
            <select name="locale" size="1">
                <option value="en"> en </option>
                <option value="ua"> ua </option>
            </select>
            <input type="submit" value="<fmt:message key="command.set.language" bundle="${lan}" />">
        </form>
        <h2 align="center"><fmt:message key="${sessionScope.trainType}" bundle="${lan}" /></h2>
        <div align="center">
            ${sessionScope.train}
            <br>
            <br>
            ${requestScope.result}
            <br>
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/filling">
                <fmt:message key="message.command.fill" bundle="${lan}" /> <br>
                <input type="submit" value="<fmt:message key="command.fill" bundle="${lan}" />">
            </form>
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/counting">
                <fmt:message key="message.command.count" bundle="${lan}" /> <br>
                <input type="submit" value="<fmt:message key="command.count" bundle="${lan}" />">
            </form>
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/sorting">
                <fmt:message key="message.command.sort" bundle="${lan}" /> <br>
                <input type="submit" value="<fmt:message key="command.sort" bundle="${lan}" />">
            </form>
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/searching">
                <fmt:message key="message.command.search" bundle="${lan}" /> <br>
                <input type="text" name="start" size="1">
                <input type="text" name="end" size="1">
                <input type="submit" value="<fmt:message key="command.search" bundle="${lan}" />">
            </form>
        </div>
    </body>
</html>
