<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="message" var="msg"/>
<html>
<head>
    <title>格式化示例:日期</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>
<h1>${now}</h1>
<h1><fmt:formatDate value="${now}"/></h1>
<h1><fmt:formatDate value="${now}" type="date"
         dateStyle="short" /></h1>
<h1><fmt:formatDate value="${now}" type="both"
         pattern="yyyy-MM-dd HH:mm:ss" /></h1>
</body>
</html>
