<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>remove与catch</title>
</head>
<body>
<c:set var="s" value="str in page" />
<c:set var="s" value="str in request" scope="request"/>
<c:set var="s" value="str in session" scope="session"/>
<c:set var="s" value="str in application" scope="application"/>
<h2>${s}</h2>
<c:remove var="s" scope="page"/>
<h2>${s}</h2>
<hr>
<c:catch var="ex">
    <c:set var="n" value="${param.num+1}"/>
    <h2>n=${n}</h2>
</c:catch>
<h2>${ex}</h2>
</body>
</html>
