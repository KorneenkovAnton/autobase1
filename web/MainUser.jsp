<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
<form action="/logout">
    <button>Logout</button>
</form>
<div class="login-page">
    <div class="form">
        <form action="/newReq">
            Add your Request
            <select name="feature" required>
                <c:forEach var="feature" items="features">
                    <option value="CAR">CAR</option>
                    <option value="BUS">BUS</option>
                </c:forEach>
            </select></p>
            <input type="date">
            <button>Next</button>
        </form>
    </div>
</div>
</body>
</html>
