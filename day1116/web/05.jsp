<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include动作与指令的区别</title>
</head>
<body>
<h1>include动作与指令的区别</h1>
<%--1.指令是嵌入页面为一个整体进行转译、编译，动作是转发
    2.指令是page作用域，动作是request作用域
    3.指令无法传参数，也无需传参数；动作可以2种方式传参数--%>
<h1>this is 05.jsp</h1>
<jsp:useBean id="user" class="com.xt.entity.User" />
<%@ include file="WEB-INF/pages/inc.jsp" %>
<h1>this is 05.jsp</h1>
</body>
</html>
