<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form action="/register" method="post">
                <input type="text" name="login" placeholder="login" required="required">
                <input type="password" name="password" required="required">
                <button>Register</button>
            </form>
        </div>
    </div>
</body>
</html>
