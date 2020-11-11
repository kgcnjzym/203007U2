<%--
  Created by IntelliJ IDEA.
  User: yangweibing
  Date: 2020/11/11
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转发</title>
</head>
<body>
<%--    跳转方式：
1.重定向
2.转发
--%>
<%
    String name=request.getParameter("name");
    if("admin".equals(name)){
        request.getRequestDispatcher("first.jsp")
                .forward(request,response);
    }
    else if ("root".equals(name)){
        request.getRequestDispatcher("/first.jsp")
                .forward(request,response);
    }
    else if ("baidu".equals(name)){
        request.getRequestDispatcher("http://www.baidu.com")
                .forward(request,response);
    }
    else if ("error".equals(name)){
        response.sendError(404,"文件不存在！");
    }
    else{
        request.getRequestDispatcher("form.jsp")
                .forward(request,response);
    }
%>
</body>
</html>
