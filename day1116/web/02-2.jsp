<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>class与type的区别</title>
</head>
<body>
<jsp:useBean id="u1" type="com.xt.entity.User" scope="session"/>
<h1><jsp:getProperty name="u1" property="name"/></h1>

</body>
</html>
