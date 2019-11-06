<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
<form action="/logout">
    <button>Logout</button>
</form>
<div class="login-page">
    <div class="form">
        <a href="DriverCars.jsp">My cars</a>
        <a href="DriverFlights.jsp">My flights</a>
    </div>
</div>

</body>
</html>
