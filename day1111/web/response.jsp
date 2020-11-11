<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重定向</title>
</head>
<body>
<%--    跳转方式：
1.重定向
2.转发
--%>
<%
    String name=request.getParameter("name");
    if("admin".equals(name)){
        response.sendRedirect("first.jsp");
    }
    else if ("root".equals(name)){
        response.sendRedirect("/day1111/first.jsp");
    }
    else if ("baidu".equals(name)){
        response.sendRedirect("http://www.baidu.com");
    }
    else if ("error".equals(name)){
        response.sendError(404,"文件不存在！");
    }
    else{
        response.sendRedirect("form.jsp");
    }
%>
</body>
</html>
