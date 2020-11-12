<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application</title>
</head>
<body>
    <%
        application.setAttribute("name",
                request.getParameter("name"));
    %>
<h1>name in application:<%=application.getAttribute("name")%></h1>
    <a href="third-2.jsp">read name</a>
</body>
</html>
