<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>forEach示例2</title>
</head>
<body>
<table width="500" border="1">
    <thead>
    <tr>
        <th>hobby</th>
        <th>index</th>
        <th>count</th>
        <th>first</th>
        <th>last</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="h" items="${paramValues.hobby}"
               varStatus="sta" step="2">
        <tr>
            <td>${h}</td>
            <td>${sta.index}</td>
            <td>${sta.count}</td>
            <td>${sta.first}</td>
            <td>${sta.last}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>

<%--for(Object en:ss) Map.Entry--%>
<c:forEach var="en"  items="${header}">
    <h2>${en.key}:${en.value}</h2>
</c:forEach>

</body>
</html>
