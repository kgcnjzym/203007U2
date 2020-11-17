<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL内置对象</title>
</head>
<body>
<h2>name:${param.name}</h2>
<h2>first-name:${param.first-name}</h2>
<h2>first-name:${param['first-name']}</h2>
<h2>hobbys:${paramValues.hobby}</h2>
<h2>browser:${header['user-agent']}</h2>
<h2>cookie:${cookie.name.name}=${cookie.name.value}</h2>
<h2>password:${initParam.password}</h2>
<h2>session id:<%=session.getId()%></h2>
<%--session.getAttribute("id")--%>
<h2>session id:${pageContext.session.id}</h2>
</body>
</html>
