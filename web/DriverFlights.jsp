<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
<form action="/logout">
    <button>Logout</button>
</form>
<div class="login-page">
    <div class="form">
        <c:forEach var="flight" items="${flights}">
            <form action="/markFlight" method="post">
                <p>Flight №${flight.id}</p>
                <input type="hidden" value="${flight.id}" name="flight_id">
                <p><select name="car_state">
                    <option value="GOOD">GOOD</option>
                    <option value="REPAIR">REPAIR</option>
                </select> </p>
                <input type="checkbox" id="ch" value="true" name="Flight_mark">
                <input type="hidden" name="car_id" value="${flight.car.id}">
                <label for="ch">Done</label>
                <button>Update</button>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
