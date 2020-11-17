<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include动作</title>
</head>
<body>
<%
//    request.getRequestDispatcher("..").include(request,response);
%>
<h1>this is 04.jsp</h1>
<jsp:useBean id="user" class="com.xt.entity.User"  />
<jsp:include page="/WEB-INF/pages/inc.jsp?age=20">
    <jsp:param name="name" value="andy"/>
</jsp:include>
<h1>this is 04.jsp</h1>
</body>
</html>
