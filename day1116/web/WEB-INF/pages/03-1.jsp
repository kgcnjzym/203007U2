<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward转发目标页面</title>
</head>
<body>
<jsp:useBean id="user" type="com.xt.entity.User" scope="request"/>
<h1>this is 03-1.jsp</h1>
<h2>name:<%=request.getParameter("name")%></h2>
<h2>age:<%=request.getParameter("age")%></h2>
<h2>email:<%=request.getParameter("email")%></h2>
</body>
</html>
