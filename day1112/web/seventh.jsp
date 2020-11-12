<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建cookie</title>
</head>
<body>
<%
Cookie ck=new Cookie("name","andy");
response.addCookie(ck);
Cookie ck2=new Cookie("age","20");
ck2.setMaxAge(3600*24*7);
response.addCookie(ck2);
%>
</body>
</html>
