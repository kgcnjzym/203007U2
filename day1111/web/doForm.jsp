<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: yangweibing
  Date: 2020/11/11
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求数据处理页面</title>
</head>
<body>
<%
    if("POST".equalsIgnoreCase(request.getMethod())){
        request.setCharacterEncoding("UTF-8");
    }
%>
<h2>name:<%=request.getParameter("name")%></h2>
<h2>pass:<%=request.getParameter("pass")%></h2>
<h2>email:<%=request.getParameter("email")%></h2>
<h2>gender:<%=request.getParameter("gender")%></h2>
<h2>hobby:<%=request.getParameter("hobby")%></h2>
<h2>hobbys:<%=Arrays.toString(request.getParameterValues("hobby"))%></h2>
</body>
</html>
