<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CKE提交页面</title>
    <link rel="stylesheet" href="ckeditor/contents.css">
</head>
<body>
    <c:out value="${param.cke}" escapeXml="false"/>
</body>
</html>
