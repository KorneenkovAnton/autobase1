<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCar</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
<div class="login-page">
    <form class="form" action="/addCar">
        <label for="1">Car Number</label>
        <input id="1" type="text">
        <p>
            <select name="feature" required>
                <option value="CAR">CAR</option>
                <option value="BUS">BUS</option>
            </select>
        </p>
        <p>
            <select name="user_id" required>
                <C:forEach var="user" items="${users}">
                    <option value="${user.id}">${user.login}</option>
                </C:forEach>
            </select>
        </p>
        <button>ADD</button>
    </form>
</div>
</body>
</html>
