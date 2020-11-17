<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward动作</title>
</head>
<body>
<jsp:useBean id="user" class="com.xt.entity.User" scope="request"/>
<jsp:forward page="/WEB-INF/pages/03-1.jsp?email=222">
    <jsp:param name="name" value="tom"/>
    <jsp:param name="age" value="20"/>
</jsp:forward>
</body>
</html>
