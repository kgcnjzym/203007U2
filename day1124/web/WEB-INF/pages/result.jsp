<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图片上传结果</title>
</head>
<body>
<c:if test="${msg eq 'ok'}" var="rt">
    <h2>文件描述：${desc}</h2>
    <img src="${imgSrc}">
</c:if>
<c:if test="${not rt}">
    <h2>${msg}</h2>
</c:if>
</body>
</html>
