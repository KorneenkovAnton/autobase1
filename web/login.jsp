<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href = "${pageContext.request.contextPath}/style.css" rel = "stylesheet" type = "text/css"/>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form class="login-form" action="/login" method="post">
                <input type="text" name="login" placeholder="login" required="required">
                <input type="password" name="password" required="required">
                <button>Login</button>
                <p class="message">Not registered? <a href="/register.jsp">Create an account</a></p>
            </form>
        </div>
    </div>
</body>
</html>
