<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>import示例</title>
</head>
<body>
<c:set var="str" value="first" />
<c:set var="str" value="second" scope="request" />
<h1>this is 08</h1>
<c:import url="/WEB-INF/pages/inc.jsp?name=mike" var="content">
    <c:param name="age" value="23"/>
</c:import>
<h1>this is 08</h1>
<c:out value="${content}"/>
</body>
</html>
