<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>class与type的区别</title>
</head>
<body>
<jsp:useBean id="u1" class="com.xt.entity.User" scope="session"/>
<jsp:setProperty name="u1" property="name" value="mike"/>
<%--<jsp:useBean id="u2" type="com.xt.entity.User" scope="session"/>--%>
<a href="02-2.jsp">Link 02-2</a>

</body>
</html>
