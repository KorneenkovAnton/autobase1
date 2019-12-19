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
        <a href="AdminFlights.jsp">Flights</a>
        <a href="AdminAddCars.jsp">Add Car</a>
    </div>
</div>
</body>
</html>
