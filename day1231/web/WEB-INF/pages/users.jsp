
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>users.jsp</title>
</head>
<body>
<table width="500" border="1" align="center">
    <thead>
    <tr>
        <th>name</th>
        <th>email</th>
        <th>phone</th>
        <th>age</th>
        <th>gender</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${users.list}">
        <tr>
            <td>${u.name}</td>
            <td>${u.email}</td>
            <td>${u.phone}</td>
            <td>${u.age}</td>
            <td>${u.gender}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
