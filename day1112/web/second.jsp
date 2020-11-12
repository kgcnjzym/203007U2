<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
    <h1>id:<%=session.getId()%></h1>
    <%
        //session.setMaxInactiveInterval();
        //session.invalidate();
    %>
</body>
</html>
