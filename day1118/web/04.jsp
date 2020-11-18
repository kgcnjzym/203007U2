<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>if与choose</title>
</head>
<body>
<c:catch var="ex">
    <c:set var="n" value="${param.num+1}"/>
    <h2>n=${n}</h2>
</c:catch>
<c:if test="${not empty ex}">
<h2>${ex}</h2>
</c:if>
<hr>
<c:if test="${param.name eq 'admin'}" var="rt">
    <h2>Welcome Administrator</h2>
</c:if>
<c:if test="${not rt}">
    <h2>Welcome User</h2>
</c:if>
<hr>
<c:choose>
    <c:when test="${param.month eq 1 }">31</c:when>
    <c:when test="${param.month eq 2 }">28</c:when>
    <c:when test="${param.month eq 3 }">31</c:when>
    <c:when test="${param.month eq 4 }">30</c:when>
    <c:otherwise>error month</c:otherwise>
</c:choose>
</body>
</html>
