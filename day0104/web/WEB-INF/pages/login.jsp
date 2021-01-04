<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" >
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<form action="user/login">
    <p>
        <label>Name:</label>
        <input type="text" name="name">
    </p>
    <p>
        <label>Pass:</label>
        <input type="text" name="password">
    </p>
    <p>
        <button>Login</button>
    </p>
</form>
</body>
</html>
