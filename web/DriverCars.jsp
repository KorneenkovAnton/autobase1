<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyCars</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
<form action="/logout">
    <button>Logout</button>
</form>
<div class="login-page">
    <DIV CLASS="form">
    <c:forEach var="car" items="${cars}">
        <form action="/markCarState" method="post">
            <p>Car number ${car.id}</p>
            <p><select name="car_state">
                <option value="${car.carState}">${car.carState}</option>
                <c:choose>
                    <c:when test="${car.carState == 'GOOD'}">
                        <option value="REPAIR">REPAIR</option>
                    </c:when>
                    <c:otherwise>
                        <option value="GOOD">GOOD</option>
                    </c:otherwise>
                </c:choose>
            </select> </p>
            <input type="hidden" name="car_id" value="${car.id}">
            <button>Update</button>
        </form>
    </c:forEach>
    </DIV>
</div>
</body>
</html>
