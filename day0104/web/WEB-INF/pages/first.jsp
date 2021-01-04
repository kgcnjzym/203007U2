<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" >
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
    <h1>this is first.jsp</h1>
    <h1>name in session:${sessionScope.name}</h1>
    <hr>
    <h1>user in request:${requestScope.user}</h1>
    <h1>age in request:${requestScope.age}</h1>
</body>
</html>
