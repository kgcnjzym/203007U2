<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安全退出</title>
</head>
<body>
    <%
        session.removeAttribute("user");
        Cookie ck=new Cookie("name","");
        response.addCookie(ck);

    %>
    <%@ include file="/WEB-INF/pages/menu.jsp"%>
<h3>已安全退出，请重新<a href="login.jsp">登陆</a></h3>
    <%

        session.invalidate();

    %>
</body>
</html>
