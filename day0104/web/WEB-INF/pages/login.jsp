<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>login</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" >
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<h2>${msg}</h2>
<form:form action="user/login"  commandName="user">
    <p>
        <label>Name:</label>
        <input type="text" name="name">
        <form:errors path="name"/>
    </p>
    <p>
        <label>Pass:</label>
        <input type="text" name="password">
        <form:errors path="password"/>
    </p>
    <p>
        <label>Code:</label>
        <input type="text" name="code">
        <form:errors path="age"/>
    </p>
    <p>
        <button>Login</button>
    </p>
    <p>
        <form:errors path="*"/>
    </p>
</form:form>

</body>
</html>
