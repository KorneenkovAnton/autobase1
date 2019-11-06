<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
<form action="/logout">
    <button>Logout</button>
</form>
<div class="login-page">
    <div class="form">
        <c:forEach var="flight" items="${flights}">
                    <form action="/appoint">
                        <p>Flight №${flight.id}</p>
                        <p>Feature:${flight.req.feature}</p>
                        <p><select name="car_id" required>
                            <option value="${flight.car.id}">${flight.car.id} ${car.feature}</option>
                            <c:forEach var="car" items="${cars}">
                                <c:if test="${car.id != flight.car.id}">
                                    <option value="${car.id}">${car.id} ${car.feature}</option>
                                </c:if>
                            </c:forEach>
                        </select></P>
                        <input type="hidden" value="${flight.id}" name="flight_id">
                        <input type="submit" value="Назначить">
                    </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
