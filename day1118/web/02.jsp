<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>set</title>
</head>
<body>
<c:set var="str" value="${param.name}" scope="request"/>
<h2>str:${str}</h2>
<h2>str in page:${pageScope.str}</h2>
<hr>
<jsp:useBean id="user" class="com.xt.entity.User"/>
<%--<jsp:setProperty name="user" property="name" value="mike"/>--%>
<h2>name : ${user.name}</h2>
<c:set target="${user}" property="name">
    sdknnas,dmm,.sd. ms.das .msda
</c:set>
<h2>name : ${user.name}</h2>
<hr>
<jsp:useBean id="map" class="java.util.HashMap" />
<c:set target="${map}" property="name" value="tony"/>
<c:set target="${map}" property="first-name" value="mike"/>
<h2>map.name:${map.name}</h2>
<h2>map['first-name']:${map['first-name']}</h2>
</body>
</html>
