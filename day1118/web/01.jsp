<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSTL引用与out</title>
</head>
<body>
    <%
        pageContext.setAttribute("str","<h1>hello</h1>");
    %>
    ${str}
    <hr>
    <c:out value="${str}"/>
    <hr>
    ${sss}
    <hr>
    <c:out value="${sss}" default="no value"/>
</body>
</html>
