<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first-2</title>
</head>
<body>
<h1>name in page:<%=pageContext.getAttribute("name")%></h1>
<h1>name in request:<%=request.getAttribute("name")%></h1>
</body>
</html>
