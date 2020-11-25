<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>add in application</title>
  </head>
  <body>
  <h1>添加或修改数据</h1>
  <c:set var="name" value="${param.name}" scope="application"/>
  <h3><a href="appdel.jsp">删除数据</a></h3>
  </body>
</html>
