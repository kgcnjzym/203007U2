<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>reg</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" >
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<form:form action="fourth/reg"  commandName="user">
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
        <label>Age:</label>
        <input type="text" name="age">
        <form:errors path="age"/>
    </p>
    <p>
        <label>Email:</label>
        <input type="text" name="email">
        <form:errors path="email"/>
    </p>
    <p>
        <label>Birth:</label>
        <input type="text" name="birth">
        <form:errors path="birth"/>
    </p>
    <p>
        <button>Reg</button>
    </p>
</form:form>
</body>
</html>
