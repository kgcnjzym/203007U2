<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inc</title>
</head>
<body>
<h1>this is inc.jsp</h1>
<h1><%=user%></h1>
<h2>name:<%=request.getParameter("name")%></h2>
<h2>age:<%=request.getParameter("age")%></h2>
</body>
</html>
