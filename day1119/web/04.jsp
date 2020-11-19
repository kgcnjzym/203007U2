<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>函数标签示例1</title>
</head>
<body>
<c:set var="s" value="hello world"/>
<h1>str length:${fn:length(s)}</h1>
<jsp:useBean id="lst" class="java.util.ArrayList"/>
<%
    lst.add("ddd");    lst.add("eeee");
    lst.add(null);    int []arr={3,5,6,8};
    pageContext.setAttribute("arr",arr);
%>
<jsp:useBean id="map" class="java.util.HashMap"/>
<c:set target="${map}" property="name" value="mike"/>
<c:set target="${map}" property="age" value="20"/>
<h1>list length:${fn:length(lst)}</h1>
<h1>arr length:${fn:length(arr)}</h1>
<h1>map length:${fn:length(map)}</h1>
</body>
</html>
