<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>请求头信息</title>
</head>
<body>
    <h2>浏览器：<%=request.getHeader("user-agent")%></h2>
    <%
        Enumeration<String> names=request.getHeaderNames();
        while(names.hasMoreElements()){
            String n=names.nextElement();
            String v=request.getHeader(n);
    %>
            <h2><%=n%>=<%=v%></h2>
        <%}
    %>
</body>
</html>
