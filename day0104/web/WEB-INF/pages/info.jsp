<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userinfo</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" >
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
    <h1>welcome:【${sessionScope.user1}】</h1>
    <h1>user1 in req:${requestScope.user1}</h1>
</body>
</html>
