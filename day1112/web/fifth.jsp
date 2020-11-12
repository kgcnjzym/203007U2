<%@ page contentType="text/html;charset=UTF-8"
         language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>exception</title>
</head>
<body>
<%
    int a=Integer.parseInt(request.getParameter("a"));
    int b=Integer.parseInt(request.getParameter("b"));
    int c=a/b;
%>
<h1>c=<%=c%></h1>
</body>
</html>
