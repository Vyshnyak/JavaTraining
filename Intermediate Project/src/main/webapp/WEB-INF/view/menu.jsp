<html>
    <body>
        <h2 align="center">Train</h2>
        <div align="center">${requestScope.train}
            <br>
            <br>
            ${requestScope.result}
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/counting">
                Count all passengers and baggage <br>
                <input type="submit" value="Count">
            </form>
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/sorting">
                Sort wagons by comfort value <br>
                <input type="submit" value="Sort">
            </form>
            <br>
            <br>
            <form method="GET" action="${pageContext.request.contextPath}/app/searching">
                Find wagons with amount of passengers in range: <br>
                <input type="text" name="offset" size="1">
                <input type="text" name="end" size="1">
                <input type="submit" value="Search">
            </form>
        </div>
    </body>
</html>
