<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <body>
    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="messages" var="lan" />
        <form method="GET" action="${pageContext.request.contextPath}/app/language/index">
            <select name="locale" size="1">
                <option value="en"> en </option>
                <option value="ua"> ua </option>
            </select>
            <input type="submit" value="Set">
        </form>
        <div align="center">
            <h2><fmt:message key="main.page.title" bundle="${lan}" /></h2>
            <br/>
            <form method="GET" action="${pageContext.request.contextPath}/app/building">
                <select name="trainType" size="1">
                    <option value="Passenger Train"> <fmt:message key="passenger.train" bundle="${lan}" /> </option>
                </select>
                <input type="submit" value="<fmt:message key="command.build" bundle="${lan}" />">
            </form>
        </div>
</body>
</html>