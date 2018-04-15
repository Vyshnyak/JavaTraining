<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <body>
    <fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : initParam.language}" />
    <fmt:setBundle basename="messages" var="lan" />
        <form method="GET" action="${pageContext.request.contextPath}/app/language">
            <select name="locale" size="1">
                <option value="en"> en </option>
                <option value="ua"> ua </option>
                <input type="hidden" name="pageName" value="/" />
            </select>
            <input type="submit" value="<fmt:message key="command.set.language" bundle="${lan}" />">
        </form>
        <div align="center">
            <h2><fmt:message key="main.page.title" bundle="${lan}" /></h2>
            <br/>
            <form method="GET" action="${pageContext.request.contextPath}/app/build">
                <select name="trainType" size="1">
                    <option value="Passenger Train"> <fmt:message key="passenger.train" bundle="${lan}" /> </option>
                </select>
                <input type="submit" value="<fmt:message key="command.build" bundle="${lan}" />">
            </form>
        </div>
</body>
</html>