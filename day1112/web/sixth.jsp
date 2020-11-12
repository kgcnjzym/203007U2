<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL重写</title>
</head>
<body>
    <%
        session.setAttribute("name",
                request.getParameter("name"));

        String url=response.encodeURL("sixth-2.jsp");
    %>
    <a href="<%=url%>">read session</a>
</body>
</html>
