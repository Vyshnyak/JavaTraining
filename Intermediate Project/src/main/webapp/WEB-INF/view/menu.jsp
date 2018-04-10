<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <style type="text/css">
            .box {
                border: 1px solid red;
                padding: 5px;
                font-size: large;
            }
        </style>
    </head>
    <body>
    <fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : initParam.language}" />
    <fmt:setBundle basename="messages" var="lan" />
        <form method="GET" action="${pageContext.request.contextPath}/app/language">
            <select name="locale" size="1">
                <option value="en"> en </option>
                <option value="ua"> ua </option>
                <input type="hidden" name="pageName" value="/WEB-INF/view/menu.jsp" />
            </select>
            <input type="submit" value="<fmt:message key="command.set.language" bundle="${lan}" />">
        </form>
        <h2 align="center"><fmt:message key="${sessionScope.trainType}" bundle="${lan}" /></h2>
        <div align="center">
            <span class="box">${sessionScope.train.locomotive}</span>
            <c:forEach var="baggageWagon" items="${sessionScope.train.baggageWagons}">
                <span class="box">${baggageWagon}</span>
            </c:forEach>
            <c:forEach var="passengerWagon" items="${sessionScope.train.passengerWagons}">
                <span class="box">${passengerWagon}</span>
            </c:forEach>
            <br>
            <br>
            <br>
            <div>
                <c:if test="${not empty requestScope.result}">
                    <fmt:message key="${requestScope.result}" bundle="${lan}" />
                </c:if>
                <c:if test="${not empty requestScope.countResult}">
                    <fmt:message key="${requestScope.countResult}" bundle="${lan}">
                        <fmt:param value="${requestScope.passengers}" />
                        <fmt:param value="${requestScope.baggage}" />
                    </fmt:message>
                </c:if>
                <c:if test="${not empty requestScope.searchResult}">
                    <c:forEach var="wagon" items="${requestScope.searchResult}">
                        <span class="box">${wagon}</span>
                    </c:forEach>
                </c:if>
            </div>
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
            <a href="${pageContext.request.contextPath}">Return to main page</a>
        </div>
    </body>
</html>
