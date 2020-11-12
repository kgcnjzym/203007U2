<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>主页</title>
</head>
<body>

    <h2>欢迎：【<%=user.getName()%>】</h2>
<a href="modifyInfo.jsp">修改信息</a>
<a href="modifyPass.jsp">修改密码</a>
    <a href="logoff.jsp">安全退出</a>
</body>
</html>
