<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>url示例</title>
</head>
<body>
<h1>
<c:url value="index.jsp?name=tom" var="link">
    <c:param name="age" value="23"/>
</c:url>
</h1>
<h2><a href="${link}">Link</a></h2>
</body>
</html>
