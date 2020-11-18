<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>forEach示例1</title>
    <style>
        body{
            font-family: "Courier New";
        }
    </style>
</head>
<body>
<h2>九九乘法表</h2>
<c:forEach var="i" begin="1" end="9" >
    <c:forEach var="j" begin="1" end="${i}">
        ${j}*${i}=${j*i}<c:if test="${j*i lt 10}">&nbsp;</c:if>
    </c:forEach>
    <br>
</c:forEach>
<hr>
<c:forEach var="i" begin="1" end="10" >
    ${11-i}<br>
</c:forEach>
</body>
</html>
