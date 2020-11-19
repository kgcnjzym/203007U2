<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="message" var="msg"/>
<html>
<head>
    <title>格式化示例:数字</title>
</head>
<body>
<c:set var="num" value="1234567"/>
<c:set var="n" value="0.1234567"/>
<h1><fmt:formatNumber value="${num}"
         groupingUsed="false"/> </h1>
<h1><fmt:formatNumber value="${n}"
         minFractionDigits="4"/> </h1>
<h1><fmt:formatNumber value="${num}"
         type="currency" currencySymbol="$"/> </h1>
<h1><fmt:formatNumber value="${n}"
         type="percent" minFractionDigits="2"/> </h1>
</body>
</html>
